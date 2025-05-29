

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Skill {
        int damage;
        int spCost; // Negative for SP gain
        int postDelay; // Actual duration, e.g., 1 means busy for this sec, next sec free
        int cooldown;  // Actual duration, e.g., 3 means needs 3 sec to become 0

        public Skill(int damage, int spCost, int postDelay, int cooldown) {
            this.damage = damage;
            this.spCost = spCost;
            this.postDelay = postDelay;
            this.cooldown = cooldown;
        }
    }

    static Skill[] skillsInfo; // Renamed from skills to avoid conflict
    static int P_TARGET; // Renamed from P to avoid conflict with class P or parameter P

    // dp[sp][strike_cd_rem][headbutt_cd_rem][global_post_delay_rem]
    // strike_cd_rem: 0 (ready) up to skillsInfo[2].cooldown (e.g., 3 if just used)
    // headbutt_cd_rem: 0 (ready) up to skillsInfo[3].cooldown (e.g., 8 if just used)
    // global_post_delay_rem: 0 (can act) up to MAX_POST_DELAY (e.g., 2 if just incurred)
    static int[][][][] dpStates;
    static int[][][][] nextDpStates;

    static final int MAX_SP_VALUE = 100;
    // Max actual CD values for array sizing. Add 1 for 0-based indexing.
    static final int STRIKE_FULL_CD = 3;
    static final int HEADBUTT_FULL_CD = 8;
    static final int MAX_POSSIBLE_POST_DELAY = 2; // Max post-delay among skillsInfo

    private static void initializeDpTables() {
        // Array sizes are max_value + 1 to accommodate index 0 up to max_value
        dpStates = new int[MAX_SP_VALUE + 1][STRIKE_FULL_CD + 1][HEADBUTT_FULL_CD + 1][MAX_POSSIBLE_POST_DELAY + 1];
        nextDpStates = new int[MAX_SP_VALUE + 1][STRIKE_FULL_CD + 1][HEADBUTT_FULL_CD + 1][MAX_POSSIBLE_POST_DELAY + 1];

        for (int i = 0; i <= MAX_SP_VALUE; i++) {
            for (int j = 0; j <= STRIKE_FULL_CD; j++) {
                for (int k = 0; k <= HEADBUTT_FULL_CD; k++) {
                    Arrays.fill(dpStates[i][j][k], -1);
                }
            }
        }
    }

    private static void updateNextDpStates(int sp, int sCd, int hCd, int gpd, int damage) {
        sp = Math.max(0, Math.min(MAX_SP_VALUE, sp)); // Ensure SP is within bounds

        if (damage > nextDpStates[sp][sCd][hCd][gpd]) {
            nextDpStates[sp][sCd][hCd][gpd] = damage;
        }
    }

    public static void solveCurrentTestCase() throws IOException { // Renamed solve to avoid static context issues if any
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A_dmg = Integer.parseInt(st.nextToken());
        int B_dmg = Integer.parseInt(st.nextToken());
        int C_dmg = Integer.parseInt(st.nextToken());
        P_TARGET = Integer.parseInt(st.nextToken());

        skillsInfo = new Skill[4];
        skillsInfo[0] = new Skill(100, 0, 1, 1);    // Basic Attack
        skillsInfo[1] = new Skill(A_dmg, -7, 1, 1);   // Hammering
        skillsInfo[2] = new Skill(B_dmg, 10, 2, 3);   // Strike
        skillsInfo[3] = new Skill(C_dmg, 10, 2, 8);   // Headbutt

        initializeDpTables();

        // Initial state: Before time 1 (conceptually at end of time 0)
        // SP=100, All CDs=0 (ready), GPD=0 (can act), Damage=0
        dpStates[100][0][0][0] = 0;

        for (int t = 1; t <= 600; t++) {
            // Reset nextDpStates for current time t calculation
            for (int i = 0; i <= MAX_SP_VALUE; i++) {
                for (int j = 0; j <= STRIKE_FULL_CD; j++) {
                    for (int k = 0; k <= HEADBUTT_FULL_CD; k++) {
                        Arrays.fill(nextDpStates[i][j][k], -1);
                    }
                }
            }

            int minTimeToKillThisRound = Integer.MAX_VALUE;

            for (int prevSp = 0; prevSp <= MAX_SP_VALUE; prevSp++) {
                for (int prevStrikeCd = 0; prevStrikeCd <= STRIKE_FULL_CD; prevStrikeCd++) {
                    for (int prevHeadbuttCd = 0; prevHeadbuttCd <= HEADBUTT_FULL_CD; prevHeadbuttCd++) {
                        for (int prevGpd = 0; prevGpd <= MAX_POSSIBLE_POST_DELAY; prevGpd++) {
                            if (dpStates[prevSp][prevStrikeCd][prevHeadbuttCd][prevGpd] == -1) {
                                continue; // This state was not reachable or not optimal
                            }

                            int damageSoFar = dpStates[prevSp][prevStrikeCd][prevHeadbuttCd][prevGpd];

                            // Passive updates at the START of time t
                            int currentSp = Math.min(MAX_SP_VALUE, prevSp + 1);
                            int currentStrikeCdRem = (prevStrikeCd == 0) ? 0 : prevStrikeCd - 1;
                            int currentHeadbuttCdRem = (prevHeadbuttCd == 0) ? 0 : prevHeadbuttCd - 1;
                            int currentGpdRem = (prevGpd == 0) ? 0 : prevGpd - 1;

                            // Option 1: Do nothing at time t
                            updateNextDpStates(currentSp, currentStrikeCdRem, currentHeadbuttCdRem, currentGpdRem, damageSoFar);

                            // Option 2: Use a skill AT TIME t (if currentGpdRem == 0)
                            if (currentGpdRem == 0) {
                                // Skill 0: Basic Attack
                                if (currentSp >= skillsInfo[0].spCost) { // spCost is 0, always true
                                    int damageAfterSkill = damageSoFar + skillsInfo[0].damage;
                                    if (damageAfterSkill >= P_TARGET) {
                                        minTimeToKillThisRound = Math.min(minTimeToKillThisRound, t);
                                    }
                                    int spAfterSkill = currentSp - skillsInfo[0].spCost;
                                    updateNextDpStates(spAfterSkill, currentStrikeCdRem, currentHeadbuttCdRem, skillsInfo[0].postDelay, damageAfterSkill);
                                }

                                // Skill 1: Hammering
                                // SP cost is -7 (gain). No SP check required for minimum SP to use.
                                int damageAfterSkillHammer = damageSoFar + skillsInfo[1].damage;
                                if (damageAfterSkillHammer >= P_TARGET) {
                                    minTimeToKillThisRound = Math.min(minTimeToKillThisRound, t);
                                }
                                int spAfterSkillHammer = Math.min(MAX_SP_VALUE, currentSp - skillsInfo[1].spCost);
                                updateNextDpStates(spAfterSkillHammer, currentStrikeCdRem, currentHeadbuttCdRem, skillsInfo[1].postDelay, damageAfterSkillHammer);

                                // Skill 2: Strike
                                if (currentSp >= skillsInfo[2].spCost && currentStrikeCdRem == 0) {
                                    int damageAfterSkill = damageSoFar + skillsInfo[2].damage;
                                    if (damageAfterSkill >= P_TARGET) {
                                        minTimeToKillThisRound = Math.min(minTimeToKillThisRound, t);
                                    }
                                    int spAfterSkill = currentSp - skillsInfo[2].spCost;
                                    updateNextDpStates(spAfterSkill, skillsInfo[2].cooldown, currentHeadbuttCdRem, skillsInfo[2].postDelay, damageAfterSkill);
                                }

                                // Skill 3: Headbutt
                                if (currentSp >= skillsInfo[3].spCost && currentHeadbuttCdRem == 0) {
                                    int damageAfterSkill = damageSoFar + skillsInfo[3].damage;
                                    if (damageAfterSkill >= P_TARGET) {
                                        minTimeToKillThisRound = Math.min(minTimeToKillThisRound, t);
                                    }
                                    int spAfterSkill = currentSp - skillsInfo[3].spCost;
                                    updateNextDpStates(spAfterSkill, currentStrikeCdRem, skillsInfo[3].cooldown, skillsInfo[3].postDelay, damageAfterSkill);
                                }
                            }
                        }
                    }
                }
            }

            if (minTimeToKillThisRound != Integer.MAX_VALUE) {
                sb.append(minTimeToKillThisRound).append("\n");
                return; // Monster defeated, end for this test case
            }

            // Swap dpStates and nextDpStates for the next iteration
            // The content of nextDpStates becomes the current dpStates
            int[][][][] temp = dpStates;
            dpStates = nextDpStates;
            nextDpStates = temp; // nextDpStates can be reused (it's now filled with old dpStates values, will be overwritten)
        }

        sb.append("-1\n"); // If loop finishes, P_TARGET not reached in 600s
    }

    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T_cases = Integer.parseInt(br.readLine()); // Number of test cases
        while (T_cases-- > 0) {
            solveCurrentTestCase();
        }
        System.out.print(sb.toString());
    }
}