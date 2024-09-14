import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000;
    static int N;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N+1][2][3];

        // 초기 상태 설정
        dp[1][0][0] = 1; // 출석
        dp[1][1][0] = 1; // 지각
        dp[1][0][1] = 1; // 결석

        for (int i = 2; i <= N; i++) {
            // 출석
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % MOD;
            dp[i][1][0] = (dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]) % MOD;

            // 지각
            dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % MOD;

            // 결석
            dp[i][0][1] = dp[i-1][0][0] % MOD;
            dp[i][1][1] = dp[i-1][1][0] % MOD;
            dp[i][0][2] = dp[i-1][0][1] % MOD;
            dp[i][1][2] = dp[i-1][1][1] % MOD;
        }

        long result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result = (result + dp[N][i][j]) % MOD;
            }
        }

        System.out.println(result);
    }
}