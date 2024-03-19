
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[][] arr =new int[N+1][2];

        int[][]ans = new int[N+1][goal+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[i][0]= weight;
            arr[i][1]= value;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < goal+1; j++) {
                if (arr[i][0] > j) {
                    ans[i][j] = ans[i - 1][j];
                } else {
                    int idx = j-arr[i][0];
                    ans[i][j]= Math.max(arr[i][1]+ans[i-1][idx],ans[i-1][j]);
                }
            }
        }


        System.out.println(ans[N][goal]);
    }
}
