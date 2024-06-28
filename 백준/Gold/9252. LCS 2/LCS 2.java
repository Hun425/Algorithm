import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[s1.length()][s2.length()]).append("\n");

        List<Character> lcs = findLCS(dp, s1, s2);
        for (char c : lcs) {
            sb.append(c);
        }

        System.out.println(sb);
    }

    static List<Character> findLCS(int[][] dp, String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        List<Character> lcs = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.add(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        Collections.reverse(lcs);
        return lcs;
    }
}