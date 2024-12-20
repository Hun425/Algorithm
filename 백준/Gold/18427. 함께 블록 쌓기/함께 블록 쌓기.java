import java.util.*;
import java.io.*;

public class Main {
    static int N, M, H;
    static int[][] dp;  // [학생번호][현재까지의 합]
    static ArrayList<Integer>[] students;  // 각 학생이 가진 블록들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 학생 수
        M = Integer.parseInt(st.nextToken());  // 최대 블록 수
        H = Integer.parseInt(st.nextToken());  // 목표 높이

        // 각 학생별 블록 정보 저장
        students = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            students[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                students[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // DP 배열 초기화
        dp = new int[N][H + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    // student: 현재 학생 번호, sum: 현재까지의 높이 합
    static int dfs(int student, int sum) {
        // 목표 높이에 도달한 경우
        if (sum == H) return 1;
        // 모든 학생을 확인했거나 높이가 초과된 경우
        if (student >= N || sum > H) return 0;
        
        // 이미 계산된 경우
        if (dp[student][sum] != -1) return dp[student][sum];

        // 현재 학생의 블록을 선택하지 않는 경우
        int result = dfs(student + 1, sum);

        // 현재 학생의 각 블록을 선택하는 경우
        for (int block : students[student]) {
            result = (result + dfs(student + 1, sum + block)) % 10007;
        }

        return dp[student][sum] = result;
    }
}