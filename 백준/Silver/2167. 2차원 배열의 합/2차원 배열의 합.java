import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 구간 합 배열 만들어서 생성
        int[][] s_arr = new int[N+1][M+1];
        // 첫번째 가로 생성
//
//        for (int i = 1; i <s_arr[0].length ; i++) {
//            s_arr[0][i] = arr[0][i-1];
//        }
//        for (int i = 1; i <s_arr.length ; i++) {
//            s_arr[i][0] = arr[i-1][0];
//        }
        int sum =0;
        for (int i = 1; i < M+1; i++) {
            sum +=arr[0][i-1];
            s_arr[1][i] =sum;
        }
        // 첫번째 세로 생성
        sum =0;
        for (int i = 1; i < N+1; i++) {
            sum += arr[i-1][0];
            s_arr[i][1] =sum;
        }
        // 구간합 순차적으로 전체 생성
        for (int i = 2; i < N+1; i++) {
            for (int j = 2; j< M+1; j++) {
                s_arr[i][j]= s_arr[i-1][j]+s_arr[i][j-1]-s_arr[i-1][j-1]+arr[i-1][j-1];
            }            
        }






        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        // 구간합 배열에서 바로 계산
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int result = s_arr[y2][x2]-s_arr[y1-1][x2]-s_arr[y2][x1-1]+s_arr[y1-1][x1-1];
            System.out.println(result);


//            for (int j = 0; j < s_arr.length; j++) {
//                for (int k = 0; k < s_arr[j].length; k++) {
//                    System.out.print(s_arr[j][k]+" ");
//                }
//                System.out.println();
//            }
//

        }
    }
}

