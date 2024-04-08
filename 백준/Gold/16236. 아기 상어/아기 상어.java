import java.io.*;
import java.util.*;
public class Main {
    static int y,x,cnt,N,size,eat,goaly,goalx,now;
    static boolean ck ;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        now = Integer.MAX_VALUE;
        arr = new int[N][N];// 맵 생성
        int[][] Min = new int[N][N];

        boolean[][] visited = new boolean[N][N];// 방문 배열
        size = 2;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    y=i; // 미리 출발점 구하기
                    x=j;
                    arr[i][j]=0;
                }
                Min[i][j] = Integer.MAX_VALUE;
            }
        }

        int check =3;

        while (check != 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Min[i][j]=Integer.MAX_VALUE;
                }
            }
            BFS(visited,Min);
            check(Min);
            if(!ck)break;
            eat(Min);

        }

        System.out.println(cnt);
    }
    static void eat(int[][]Min){

            arr[goaly][goalx] = 0;
            cnt += Min[goaly][goalx];
            eat++;
            y = goaly;
            x = goalx;
            if (eat == size) {
                eat = 0;
                size++;
            }
    }
    static void check(int[][]Min){
        ck = false;
        int now =Integer.MAX_VALUE;
        Loop1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (size > arr[i][j] && arr[i][j]!=0 && Min[i][j]!=Integer.MAX_VALUE) {
                    int dt = Min[i][j];
                    if (now > dt) {
                        now = dt;
                        goaly=i;
                        goalx=j;
                        ck = true;

                    }
                }
            }
        }
    }
    static void BFS(boolean [][] visited ,int[][] Min) {
        Queue<Integer[]> que = new ArrayDeque<>();
        int[][]dx = {{-1,0},{0,-1},{0,1},{1,0}};

        int time = 0;
        int cnt = 0;
        que.add(new Integer[]{y,x,time});
        Min[y][x]=0;
        Loop1:
        while (!que.isEmpty()) {
            Integer[] now = que.poll();

            for (int i = 0; i < 4; i++) {
                int del_y = now[0]+dx[i][0];
                int del_x = now[1]+dx[i][1];

                if(del_x<0||del_x>=N||del_y<0||del_y>=N)continue;
                if(size<arr[del_y][del_x])continue;
                if(Min[del_y][del_x]<=now[2]+1)continue;

                que.add(new Integer[]{del_y, del_x, now[2] + 1});
                Min[del_y][del_x]=now[2]+1;


            }
        }
    }
}