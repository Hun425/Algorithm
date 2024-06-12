import java.util.*;
import java.io.*;

public class Main {
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][]max_dp = new int[N][3];
        int[][]min_dp = new int[N][3];
        for (int i = 0; i <N ; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i][0]=a;
            arr[i][1]=b;
            arr[i][2]=c;

        }
        max =0;
        min = Integer.MAX_VALUE;

        max_dp[0][0]=arr[0][0];
        max_dp[0][1]=arr[0][1];
        max_dp[0][2]=arr[0][2];

        min_dp[0][0]=arr[0][0];
        min_dp[0][1]=arr[0][1];
        min_dp[0][2]=arr[0][2];

        for (int i = 1; i <N ; i++) {


            max_dp[i][0]=Math.max(max_dp[i-1][0],max_dp[i-1][1])+arr[i][0];
            max_dp[i][1]=Math.max(max_dp[i-1][1],max_dp[i-1][2]);
            max_dp[i][1]=Math.max(max_dp[i-1][0],max_dp[i][1])+arr[i][1];
            max_dp[i][2]=Math.max(max_dp[i-1][1],max_dp[i-1][2])+arr[i][2];


            min_dp[i][0]=Math.min(min_dp[i-1][0],min_dp[i-1][1])+arr[i][0];
            min_dp[i][1]=Math.min(min_dp[i-1][1],min_dp[i-1][2]);
            min_dp[i][1]=Math.min(min_dp[i-1][0],min_dp[i][1])+arr[i][1];
            min_dp[i][2]=Math.min(min_dp[i-1][1],min_dp[i-1][2])+arr[i][2];
        }



        for (int i = 0; i < 3; i++) {
            min = Math.min(min,min_dp[N-1][i]);
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(max,max_dp[N-1][i]);
        }

        System.out.println(max+" "+min);
    }

}