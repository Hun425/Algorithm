import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int time;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean [][]check;

    static int [][] arr;
    static Queue<Integer[]> que;
    static int[][]dx;
    static int[][] index;
    static void BFS() {

        while (!que.isEmpty()) {
            Integer[] XY = que.poll();

            for (int i = 0; i < 4; i++) {
                int y_del = XY[0] + dx[i][0];
                int x_del = XY[1] + dx[i][1];

                if (0 <= y_del && y_del < arr.length && 0 <= x_del && x_del < arr[0].length&& !check[y_del][x_del]&& arr[y_del][x_del]!=-1) {
                    check[y_del][x_del]=true;
                    que.add(new Integer[]{y_del, x_del});
                    arr[y_del][x_del]=arr[XY[0]][XY[1]]+1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        // 배열 크기 받기
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        arr = new int[y][x];
        // 배열에 토마토 받기
        index = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    index[i][j]=1;
                }
            }
        }

        // 좌표 받을 큐 생성
        que = new ArrayDeque<>();

        // 이동 좌표 생성
        dx = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        check = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (index[i][j] == 1) {
                    que.add(new Integer[]{i,j});
                    check[i][j]=true;
                }
            }
        }
        BFS();
        //최대값 변수 지정 및 구간 검사
        int mx =0;
        boolean c =false;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] > mx) {
                    mx = arr[i][j];
                }
                if (arr[i][j] == 0) {
                    c=true;
                    break;
                }
            }
            if (c) {
                break;
            }
        }

        if (c) {
            System.out.println(-1);
        } else {
            System.out.println(mx-1);
        }

    }
}