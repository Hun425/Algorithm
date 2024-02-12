import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] distance ;




    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]!=0) {
                    distance[i][j]=arr[i][j];
                } else {
                    distance[i][j]=Integer.MAX_VALUE/2-1;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int S = 0; S < N; S++) {
                for (int E = 0; E < N; E++) {
                    distance[S][E]= Math.min(distance[S][E],distance[S][k]+distance[k][E]);
                }
            }
        }


        for (int[] ints : distance) {
            for (int anInt : ints) {
                if (anInt > 10000) {
                    System.out.print(0+" ");
                } else {
                    System.out.print(1+" ");
                }
            }
            System.out.println();
        }


    }
}
/*
플로이드 워셜
3중 포문으로 한가지의 경로보다 다른 경로를 거친 합이 더 작을때 갱신해주는 방법
 */
