import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int [][] arr;
    static boolean[][]visited;
    static Queue<int[]> que;
    static Queue<int[]> idx;
    static int dx[][];
    static int N;
    static int L;
    static int R;
    static int cnt;
    static int sum;
    static int avg;
    static int ans;
    static void BFS(int y, int x) {
        que.add(new int[]{y,x});
        idx.add(new int[]{y,x});
        visited[y][x]=true;
        sum =arr[y][x];
        cnt++;
        while (!que.isEmpty()) {
            int[] XY = que.poll();

            for (int i = 0; i < 4; i++) {
                int y_del = XY[0]+dx[i][0];
                int x_del = XY[1]+dx[i][1];

                // 조건에 맞는지 검사후 국경선 열고 카운트
                if (0 <= y_del && y_del < N && 0 <= x_del && x_del < N) {
                    if (L <= Math.abs(arr[y_del][x_del]-arr[XY[0]][XY[1]]) && Math.abs(arr[y_del][x_del]-arr[XY[0]][XY[1]]) <= R && !visited[y_del][x_del]) {
                        visited[y_del][x_del] = true;
                        que.add(new int[]{y_del,x_del});
                        idx.add(new int[]{y_del,x_del});
                        sum += arr[y_del][x_del];
                        cnt++;
                    }
                }
            }
        }
        avg = sum/cnt;
        // 국경선 열린 나라 인구수 재지정
        while (!idx.isEmpty()) {
            int[] XY = idx.poll();
            arr[XY[0]][XY[1]]=avg;
        }

    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        // 범위 계산을 위한 전역변수 선언
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        // 나라 인구수 배열
        arr = new int[N][N];
        // 인구수 계산을 위한 전역변수들 선언
        cnt=0;
        avg=0;
        sum=0;
        //방문 배열 생성
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // BFS 위한 que와 좌표 저장 위한 idx 생성
        que = new ArrayDeque<>();
        idx = new ArrayDeque<>();

        // 좌표 이동을 위한 dx 생성
        dx = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ans=0;
        while (true) {
            int[][] arr2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr2[i][j]= arr[i][j];
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (!visited[i][j]) {

                        BFS(i, j);
                        sum = 0;
                        cnt = 0;
                        avg = 0;
                    }
                }
            }
            // BFS 돌린 이후 방문 전체 초기화
            visited = new boolean[N][N];
            if (Arrays.deepEquals(arr2, arr)) {
                break;
            }
            ans++;
        }
        

        System.out.println(ans);
    }
}