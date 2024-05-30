import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rot(arr, t,n,m);

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }

    static void rot(int[][]arr,int t,int n,int m){
        int s = 0; // 시작점
        int col = m; // 행 
        int row = n; // 열 


        for (int x = 0; x < t; x++) {

            int cnt = 0;
            int max = Math.min(col,row)/2;
            while (cnt<max) {

                int temp = arr[s][s];
                for (int i = s; i < col - 1; i++) {
                    arr[s][i] = arr[s][i + 1];
                }
                for (int i = s; i < row - 1; i++) {
                    arr[i][col - 1] = arr[i + 1][col - 1];
                }
                for (int i = col - 1; i > s; i--) {
                    arr[row - 1][i] = arr[row - 1][i - 1];
                }
                for (int i = row - 1; i > s; i--) {
                    arr[i][s] = arr[i - 1][s];
                }
                arr[s + 1][s] = temp;

                s++;
                row--;
                col--;
                cnt++;
            }

            s = 0; // 초기화
            col = m;
            row = n;
        }
    }
}