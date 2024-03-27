
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] map,Min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        Min = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]= Integer.parseInt(String.valueOf(s.charAt(j)));
                Min[i][j]=Integer.MAX_VALUE;
            }
        }

        Dijkstra(map,Min);

        System.out.println(Min[N-1][N-1]);

    }
    static void Dijkstra(int[][]arr, int[][]Min) {
        PriorityQueue<Integer[]>pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);

        int weight =0;
        if(arr[0][0]==0)weight++;

        pq.add(new Integer[]{0,0,weight});

        int[][] dx = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            Integer[] now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int y  = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];
                weight = now[2];

                if(y<0 || y>=N || x<0 ||x>=N)continue;
                if(arr[y][x]==0)weight++;
                if(Min[y][x]<=weight)continue;

                pq.add(new Integer[]{y,x,weight});
                Min[y][x]=weight;
            }
        }
    }
}
