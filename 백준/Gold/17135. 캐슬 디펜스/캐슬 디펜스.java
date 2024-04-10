import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D,enemy_y,enemy_x,cnt,ans;
    static int[][] arr;
    static int[] path;
    static List<Integer[]> cdn;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M];
        path = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0);


        System.out.println(ans);
    }
    static void DFS(int level,int start){
        if(level==3){
            cnt=0;
            int[][] backup = new int[N+1][M];
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < M; j++) {
                    backup[i][j]=arr[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {
                arr[N][path[i]]= 2;
            }
            Loop1:
            while(true) {
                if(!Finish())break;
                cdn = new ArrayList<>();
                for (int i = 0; i < M; i++) {
                    if(arr[N][i]==2) {
                        setPosition(N,i);
                        if(enemy_y==-1)continue ;

                    }
                }
                attack();
                moveEnemy();
            }
            ans = Math.max(cnt,ans);

            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < M ; j++) {
                    arr[i][j]=backup[i][j];
                }
            }
            return;
        }

        for (int i = start; i < M; i++) {
            path[level]=i;
            DFS(level+1,start+1);
        }
    }
    static void moveEnemy() {
        for (int i = N-1; i > -1; i--) {
            for (int j = M-1; j > -1; j--) {
                if(arr[i][j]==1) {
                    int y = i;
                    y++;
                    arr[i][j]=0;
                    if(y>=N)continue;
                    arr[y][j]=1;
                }
            }
        }
    }
    static void attack() {
        for (Integer[] now : cdn) {
            if(arr[now[0]][now[1]]==1){
                cnt++;
            }
            arr[now[0]][now[1]]=0;
        }
    }

    static void setPosition(int y , int x) {
        enemy_y = -1;
        enemy_x = -1;
        int count =Integer.MAX_VALUE ;
        Loop1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int dt = Math.abs(i-y)+Math.abs(j-x);

                if(dt<=D && arr[i][j]==1) {
                    if(count>=dt) {
                        if(count==dt){
                            if (enemy_x > j) {
                                enemy_y = i;
                                enemy_x = j;
                            }
                        }else {
                            count = dt;
                            enemy_y = i;
                            enemy_x = j;
                        }
                    }
                }
            }
        }

        if (enemy_x != -1) {
            cdn.add(new Integer[]{enemy_y,enemy_x});
        }
    }



    static boolean Finish() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]==1)return true;
            }
        }
        return false;
    }
}