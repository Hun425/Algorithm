
import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] map = new int[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int [][] minMap = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                minMap[i][j] = Integer.MAX_VALUE;
            }
        }

        minMap[0][0]=0;
        
        Dijkstra(minMap,map);

        System.out.println(minMap[M-1][N-1] );
    }

    static void Dijkstra(int[][]minMap,int[][]map) {
        PriorityQueue<Integer[]>que = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);

        que.add(new Integer[]{0,0,0});

        int[][] dx = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!que.isEmpty()) {
            Integer[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int y = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];

                if(y<0 || y>=M || x<0 || x>=N) continue;

                int weight = now[2]+map[y][x];

                if(weight>=minMap[y][x])continue;

                minMap[y][x]=weight;
                que.add(new Integer[]{y,x,weight});

            }
        }
    }


}
