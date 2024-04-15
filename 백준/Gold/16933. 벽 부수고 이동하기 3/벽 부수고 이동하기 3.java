import java.io.*;
import java.util.*;
public class Main {
    static int N, M, K;
    static boolean check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];//맵 생성
        int[][][] min = new int[N][M][K+1];//최소 배열
        boolean[][][] visited = new boolean[N][M][K+1];
        check = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K+1; k++) {
                    min[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        BFS(arr,min,visited);

        if(!check) System.out.println(-1);

    }
    static void BFS(int[][] arr, int[][][]min,boolean[][][]visited){
        Queue<Integer[]> que = new ArrayDeque<>();

        que.add(new Integer[]{0,0,0,1,0}); // {y,x,k,time,오전==0 오후==1}
        min[0][0][0] =0;
        int[][]dx = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!que.isEmpty()){
            Integer[] now = que.poll();
            if(now[0]==N-1 && now[1]==M-1){
                System.out.println(now[3]);
                check = true;
                break;
            }
            int check = now[4]; // 오전 오후 구분

            for (int i = 0; i < dx.length; i++) {
                int y = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];

                if(y<0 || y>=N || x<0 || x>=M)continue;
                if(visited[y][x][now[2]])continue;
                if(arr[y][x]==1){

                    if(now[2]==K)continue;
                    if (check == 0) {
                        que.add(new Integer[]{y, x, now[2] + 1, now[3] + 1, 1});
                        visited[y][x][now[2]]=true;
                        min[y][x][now[2]+1]=now[3]+1;
                    }else{
                        que.add(new Integer[]{now[0],now[1],now[2],now[3]+1,0});
                    }
                }else{

                    if(check==0){
                        que.add(new Integer[]{y,x,now[2],now[3]+1,1});
                        visited[y][x][now[2]]=true;
                        min[y][x][now[2]]=now[3]+1;
                    }else{
                        que.add(new Integer[]{y,x,now[2],now[3]+1,0});
                        visited[y][x][now[2]]=true;
                        min[y][x][now[2]]=now[3]+1;
                    }
                }
            }
        }
    }
}