

import java.util.*;
import java.io.*;
public class Main {
    static int N,M,K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M]; // 맵
        int[][] ans = new int[N][M];
        boolean[][][] visited = new boolean[N][M][K+1];// K의 범위가 10
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        BFS(ans,arr,visited);
        if (ans[N - 1][M - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else System.out.println(ans[N-1][M-1]);
    }
    static void BFS(int[][] ans,int[][]arr,boolean[][][] visited) {
        Queue<Integer[]> que = new ArrayDeque<>();

        que.add(new Integer[]{0,0,0,1});
        visited[0][0][0]= true;
        ans[0][0]=1;
        int[][] dx = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!que.isEmpty()) {
            Integer[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int y = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];
                int z = now[2];
                if(z>K)continue;
                if(y<0||y>=N||x<0||x>=M)continue;
                if(visited[y][x][z])continue;

                if (arr[y][x] == 1) {
                    que.add(new Integer[]{y, x, z + 1, now[3] + 1});
                    ans[y][x]=Math.min(ans[y][x],now[3]+1);
                    visited[y][x][z]= true;
                } else {
                    que.add(new Integer[]{y,x,z,now[3]+1});
                    ans[y][x]=Math.min(ans[y][x],now[3]+1);
                    visited[y][x][z] = true;
                }

            }
        }
    }
}
