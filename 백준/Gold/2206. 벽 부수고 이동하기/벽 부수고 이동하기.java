
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] min = new int[N][M];
        int[][] min2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j]= Integer.parseInt(String.valueOf(s.charAt(j)));
                min[i][j]= Integer.MAX_VALUE;
                min2[i][j]= Integer.MAX_VALUE;
            }
        }
        min[0][0]=1;
        min2[N-1][M-1]=1;
        BFS(0,0,arr,min);
        BFS(N-1,M-1,arr,min2);
        int ans = Math.min(min[N-1][M-1],min2[0][0]);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }


    }

    static void BFS(int s, int e ,int[][] arr,int[][]min) {
        Queue<Integer[]> que = new ArrayDeque<>();

        que.add(new Integer[]{s,e,1,0});

        int[][] dx = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean check2=false;
        while (!que.isEmpty()) {
            Integer[] now = que.poll();

            int distance = now[2];
            int check = now[3];

            for (int i = 0; i < dx.length; i++) {
                int y = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];

                if(y<0||y>=arr.length||x<0||x>=arr[0].length)continue;


                if (distance + 1 >= min[y][x]) {
                    continue;
                }
                if(arr[y][x]==1 && check==1)continue;
                if (arr[y][x] == 1) {
                    que.add(new Integer[]{y, x, distance + 1, 1});
                } else {
                    que.add(new Integer[]{y,x,distance+1,check});
                }


                min[y][x] = distance+1;
            }
        }
    }
}
