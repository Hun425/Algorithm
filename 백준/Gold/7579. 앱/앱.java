import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weight = new int[N];
        int[] value = new int[N];

        int[][] group= new int[N][2];


        st= new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            group[i][0] = weight[i];
            group[i][1] = value[i];
        }

        int[] dp = new int[10001];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            int cost = value[i];
            for (int j = 10000; j >= cost ; j--) {
                if(dp[j-cost]!=-1){
                    dp[j] =Math.max(dp[j],dp[j-cost]+weight[i]);
                }
            }

            dp[cost] = Math.max(dp[cost],weight[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            if(dp[i]>=M){
                System.out.println(i);
                break;
            }
        }


    }
}