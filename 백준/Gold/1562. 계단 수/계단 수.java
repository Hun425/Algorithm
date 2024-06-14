import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][][] dp = new long[n + 1][10][1 << 10]; // n+1 -> 계단수 , 마지막으로 나온수를 나타내는 배열 , 1<<10 -> 비트마스크를 사용한 방문처리를 위한 배열
        for (int i = 1; i <= 9; i++)
            dp[1][i][1 << i] = 1;

        for (int t = 2; t <= n; t++) {
            for (int k = 0; k <= 9; k++) {
                for (int visited = 0; visited < (1 << 10); visited++) {

                    int nextVisited = visited | (1 << k);
                    if (k == 0) dp[t][k][nextVisited] += dp[t - 1][k + 1][visited] % MOD;  //0일때는 + 연산만 가능
                    else if (k == 9) dp[t][k][nextVisited] += dp[t - 1][k - 1][visited] % MOD; //9일때는 - 연산만 가능
                    else dp[t][k][nextVisited] += dp[t - 1][k + 1][visited] % MOD + dp[t - 1][k - 1][visited] % MOD; // 둘 다 가능

                    dp[t][k][nextVisited] %= MOD; // 모든 경우를 구한 후 + 연산을 했으므로 한번 더 연산
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i][(1 << 10) - 1] % MOD; // 비트마스크의 마지막인덱스 1 111 111 111 (모든 숫자 방문)
            sum %= MOD;
        }

        System.out.println(sum);
    }
}