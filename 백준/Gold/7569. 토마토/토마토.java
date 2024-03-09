

import java.util.*;
import java.io.*;
public class Main {
    static int N,M,H;
    static boolean [][][] visited;
    static int checkbox(int[][][]box) {
        int day =0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(box[i][j][k]==0)return-1;
                   day = Math.max(box[i][j][k],day);
                }
            }
        }
        return day;
    }
    static void BFS(int[][][]box) {
        Queue<Integer[]>que = new ArrayDeque<>();

        int[][] dx = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        visited[i][j][k]=true;
                        que.add(new Integer[]{i, j, k, 0});
                    }

                }
            }
        }

        while (!que.isEmpty()) {
            Integer[] now = que.poll();

            for (int i = 0; i < dx.length; i++) {
                int h = now[0]+dx[i][0];
                int y = now[1]+dx[i][1];
                int x = now[2]+dx[i][2];

                if(h<0 || h>=H || y<0 || y>=N || x<0 || x>=M)continue;
                if(visited[h][y][x])continue;
                if(box[h][y][x]==-1)continue;

                que.add(new Integer[]{h,y,x,now[3]+1});
                visited[h][y][x]=true;
                box[h][y][x]=now[3]+1;
            }
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());//세로
        N = Integer.parseInt(st.nextToken());//가로
        H = Integer.parseInt(st.nextToken());//높이

        int[][][] box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k]=Integer.parseInt(st.nextToken());
                }
            }
        }


        BFS(box);
        int ans = checkbox(box);
        if (ans == 1) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }




    }
}
/*
1. 메서드화 시키기
2. 주석 달기
3. 변수명 자세하게 적기
 */