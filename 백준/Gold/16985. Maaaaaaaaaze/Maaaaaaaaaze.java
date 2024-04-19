import java.util.*;
import java.io.*;
public class Main {
    static int ans,cnt;
    static boolean check;
    static int[] path,path2;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] arr = new int[5][5][5];
        check = false;
        path = new int[5];
        path2 = new int[5];
        ans=Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5 ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        DFS(0,path,arr);

        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    static void rot(int[][][]arr, int floor, int rot_cnt){
        int [][] backup =  new int [5][5];


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                backup[i][j] = arr[floor][i][j];
            }
        }


        for (int k = 0; k < rot_cnt; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[floor][i][j] = backup[4-j][i];
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    backup[i][j] = arr[floor][i][j];
                }
            }
        }



    }

    static void DFS(int level, int[]path,int[][][]arr){
        if(level ==5){
            int[][][] backup = new int[5][5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        backup[i][j][k] = arr[i][j][k];
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                rot(backup,i,path[i]);
            }


            visited = new boolean[5];
            newDFS(0,path2,backup);


            return;
        }


        for (int i = 0; i < 4; i++) {
            path[level]= i;
            DFS(level+1,path,arr);
        }
    }

    static void BFS(int[][][]arr){
        boolean [][][] visited = new boolean[5][5][5];

        Queue<Integer[]>que = new ArrayDeque<>();
        int[][]dx = {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{-1,0,0},{1,0,0}};
        int time = 0;
        que.add(new Integer[]{0,0,0,time});
        visited[0][0][0]=true;
        while(!que.isEmpty()){
            Integer[] now = que.poll();
            time = now[3];
            if(now[0]==4 && now[1]==4 && now[2]==4){
                cnt= now[3];
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int z = now[0]+dx[i][0];
                int y = now[1]+dx[i][1];
                int x = now[2]+dx[i][2];

                if(z<0 || y<0 || y>=5 || x<0 || x>=5 || z>=5)continue;
                if(visited[z][y][x])continue;
                if(arr[z][y][x]==0)continue;

                visited[z][y][x]=true;
                que.add(new Integer[]{z,y,x,time+1});
            }
        }
    }
    static void newDFS(int level,int[]path,int[][][]arr){
        if(level==5){
            int[][][] newArr = new int[5][5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        newArr[i][j][k] = arr[path[i]][j][k];
                    }
                }
            }
            cnt= Integer.MAX_VALUE;
            if(newArr[0][0][0]==1 && newArr[4][4][4]==1){
                BFS(newArr);
                ans = Math.min(cnt,ans);
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            if(visited[i])continue;
            path[level]=i;
            visited[i] =true;
            newDFS(level+1,path,arr);
            visited[i] = false;
        }
    }
}