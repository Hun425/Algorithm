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
    static int dx[][];


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        que = new ArrayDeque<>();
        // 시작 좌표 미리 찾아놓기
        int y = 0;
        int x = 0;
        arr = new int[n][m];

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    y = i;
                    x = j;
                }
            }
        }
        dx = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        arr[y][x]= 0;

        que.add(new int[]{y, x});
        while (!que.isEmpty()) {
            int[]xy = que.poll();



            for (int i = 0; i < 4; i++) {
                int y_del =xy[0]+dx[i][0];
                int x_del = xy[1]+dx[i][1];

                if (0 <= y_del && y_del < arr.length && 0 <= x_del && x_del < arr[0].length && !visited[y_del][x_del]&&arr[y_del][x_del]!=0) {

                    que.add(new int[]{y_del, x_del});
                    visited[y_del][x_del]=true;

                    arr[y_del][x_del]=arr[xy[0]][xy[1]]+1;
                }
            }

        }


        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]&&arr[i][j]!=0) {
                    arr[i][j]=-1;
                }
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}