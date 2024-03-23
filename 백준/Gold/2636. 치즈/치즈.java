
import java.io.*;
import java.util.*;
public class Main {
    static int N,M,cnt,ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int time  = 0;
        while (!check(arr)) {

            BFS(0,0,arr);
            time++;
            ans= cnt;
            cnt=0;
        }
        System.out.println(time);
        System.out.println(ans);

    }

    static void BFS(int y, int x, int[][]arr) {
        Queue<Integer[]> que = new ArrayDeque<>();

        que.add(new Integer[]{y,x});

        int[][] dx={{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[N][M];
        while (!que.isEmpty()) {
            Integer[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int del_y = now[0]+dx[i][0];
                int del_x = now[1]+dx[i][1];

                if(del_y<0||del_y>=N||del_x<0||del_x>=M)continue;
                if(visited[del_y][del_x])continue;

                if (arr[del_y][del_x] == 1) {
                    arr[del_y][del_x] = 0;
                    visited[del_y][del_x]=true;
                } else {
                    que.add(new Integer[]{del_y,del_x});
                    visited[del_y][del_x]=true;
                }
            }
        }
    }
    static boolean check(int[][]arr) {
        boolean c = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                    c= false;
                }
            }
        }

        return c;
    }
}
