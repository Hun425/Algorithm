
import java.util.*;
import java.io.*;
public class Main{
    static Queue<Integer[]> que;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] arr= new int [R][C];//맵
        int[][] ans = new int[R][C];//결과배열
        boolean[][] visited = new boolean[R][C];//
        que = new ArrayDeque<>();//물의 좌표를 먼저 넣기 위한 전역 변수

        int sy = 0;//시작좌표
        int sx = 0;

        int ey = 0;//도착좌표
        int ex = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'D') {
                    arr[i][j] = 2;//목적지는 2}
                    ey = i;
                    ex = j;
                }

                else if (s.charAt(j) == 'X') {
                        arr[i][j] = 1;//장애물은 1
                    } else if (s.charAt(j) == 'S') {
                        arr[i][j] = 3;//출발점은 3
                        sy =i;
                        sx =j;
                    } else if (s.charAt(j) == '*') {
                        arr[i][j] = -1;//물은 -1}
                        que.add(new Integer[]{i, j, -1});
                        visited[i][j] = true;
                    }

                }
        }
        BFS(sy,sx,arr,visited,ans);
        if (ans[ey][ex] == 0) {
            System.out.println("KAKTUS");
        }else System.out.println(ans[ey][ex]);
    }
    static void BFS(int sy,int sx, int[][]arr, boolean[][]visited,int[][]ans) {
        que.add(new Integer[]{sy,sx,0});
        visited[sy][sx]=true;
        int[][] dx = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!que.isEmpty()) {
            Integer[] now =que.poll();

            for (int i = 0; i < 4; i++) {
                int y = now[0]+dx[i][0];
                int x = now[1]+dx[i][1];
                int time = now[2];//시간
                if(y<0 || y>=arr.length || x<0 || x>=arr[0].length)continue;
                if(visited[y][x])continue;
                if (arr[y][x]==1)continue;
                if(time==-1 && arr[y][x]==2)continue;

                if (time == -1) {
                    que.add(new Integer[]{y, x, -1});
                    visited[y][x]=true;
                } else {
                    que.add(new Integer[]{y,x,time+1});
                    ans[y][x]=time+1;
                    visited[y][x]=true;
                }

            }
        }
    }
}
