import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] check;
    static int[][] del = {{1,0},{-1,0},{0,1},{0,-1}};

    static Queue<Integer> que ;
    static int M,N,depth;

    static int BFS(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        check = new boolean[N][M];

        check[y][x] = true;
        que.offer(new int[]{y, x, 1});

        while (!que.isEmpty()) {

            int[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int a = del[i][0] + now[1];
                int b = del[i][1] + now[0];
                if ((0 <= a && a < M) && (0 <= b && b < N) && (!check[b][a])) {
                    if (graph[b][a] != 0) {
                        check[b][a] = true;
                        if (check[N - 1][M - 1] == true) {
                            return now[2];

                        }
                        que.offer(new int[]{b, a, now[2]+1});
                    }
                }

            }

        }
        return 0;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j) -'0';
            }
        }

        int cnt =BFS(0,0);
        System.out.println(cnt+1);



//
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                System.out.println(graph[i][j]);
//            }
//        }




    }
}
