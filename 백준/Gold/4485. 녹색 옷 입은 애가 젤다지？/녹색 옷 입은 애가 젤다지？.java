import java.util.*;
import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int idx = 1;

        while (true) {

            N = Integer.parseInt(br.readLine());
            if(N==0)break;
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int[][] Min = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Min[i][j] = Integer.MAX_VALUE;
                }
            }
            Min[0][0] = 0;

            Dijkstra(arr,Min);

            sb.append("Problem " +(idx++)+": "+(Min[N-1][N-1])).append("\n");

        }

        System.out.println(sb);
    }

    static void Dijkstra(int[][]arr, int[][]Min) {
        PriorityQueue<Integer[]> que = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);

        que.add(new Integer[]{0,0,arr[0][0]});

        int[][] dx = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!que.isEmpty()) {
            Integer[]now = que.poll();


            for (int i = 0; i < 4; i++) {
                int y = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];

                if(y<0 || y>=N || x<0 || x>=N)continue;
                if(now[2]+arr[y][x]>=Min[y][x])continue;

                Min[y][x] = now[2]+arr[y][x];
                que.add(new Integer[]{y,x,Min[y][x]});
            }
        }
    }
}
