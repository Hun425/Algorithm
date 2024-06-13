import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N + 1][N + 1];

            // 거리 배열 초기화
            for (int i = 1; i <= N; i++) {
                Arrays.fill(arr[i], Integer.MAX_VALUE / 2);  // 오버플로 방지를 위해 최대값의 절반으로 초기화
                arr[i][i] = 0;  // 자기 자신으로의 거리는 0으로 설정
            }

            // 도로 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[s][e] = Math.min(arr[s][e], v);
                arr[e][s] = Math.min(arr[e][s], v);
            }

            // 웜홀 입력
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[s][e] = Math.min(arr[s][e], -v);
            }

            // Floyd-Warshall 알고리즘
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                       
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        
                    }
                }
            }

            // 음의 사이클 존재 여부 확인
            boolean hasNegativeCycle = false;
            for (int i = 1; i <= N; i++) {
                if (arr[i][i] < 0) {
                    hasNegativeCycle = true;
                    break;
                }
            }

            if (hasNegativeCycle) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}