import java.util.*;
import java.io.*;
public class Main {

    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.MAX_VALUE; // 최소거리 계산위해 최대값으로 초기화
            }
        }

        int K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());

            traffic(y,x,v,arr);
        }

        GoToSchool(arr);

        if(arr[N-1][M-1]==Integer.MAX_VALUE) System.out.println("NO");
        else {
            System.out.println("YES");
            System.out.println(arr[N-1][M-1]);
        }

    }

    static void traffic(int y, int x, int v,int[][]arr){
        int[][] dx = {{1,-1},{1,1},{-1,1},{-1,-1}};

        y = y-v; // 마름모 모양으로 테두리만 검사할 것!

        if(y<N && y>=0 && x<M && x>=0)arr[y][x]=-1;

        for (int i = 0; i < v; i++) {
            y = y+dx[0][0];
            x = x+dx[0][1];
            if(y<N && y>=0 && x<M && x>=0)arr[y][x]=-1;
        }

        for (int i = 0; i < v; i++) {
            y = y+dx[1][0];
            x = x+dx[1][1];
            if(y<N && y>=0 && x<M && x>=0)arr[y][x]=-1;
        }

        for (int i = 0; i < v; i++) {
            y = y+dx[2][0];
            x = x+dx[2][1];
            if(y<N && y>=0 && x<M && x>=0)arr[y][x]=-1;
        }

        for (int i = 0; i < v; i++) {
            y = y+dx[3][0];
            x = x+dx[3][1];
            if(y<N && y>=0 && x<M && x>=0)arr[y][x]=-1;
        }

    }

    static void GoToSchool(int[][] arr){
        Queue<Integer[]> q = new ArrayDeque<>();

        int[][]dx = {{0,1},{1,0},{0,-1},{-1,0}};

        q.add(new Integer[]{0,0,0});
        arr[0][0] = 0;
        while(!q.isEmpty()){
            Integer[] temp = q.poll();

            int dt = temp[2];

            for (int i = 0; i < 4; i++) {
                int del_y = temp[0] + dx[i][0];
                int del_x = temp[1] + dx[i][1];

                if(del_y>=N || del_x>=M || del_y<0 || del_x<0) continue;
                if(arr[del_y][del_x]==-1)continue;
                if(dt+1>=arr[del_y][del_x])continue;

                arr[del_y][del_x] = dt+1;
                q.add(new Integer[]{del_y,del_x,dt+1});
            }
        }
    }
}