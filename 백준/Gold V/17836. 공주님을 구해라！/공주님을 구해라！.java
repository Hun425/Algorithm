import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static boolean attack;
    static Queue<Integer[]>que;
    static int[][] arr ;

    static boolean[][] visited;
    static int[][] dx;
    static int sword_y, sword_x;
    static void BFS(int y, int x) {
        que.add(new Integer[]{y, x,0});
        visited[y][x]=true;
        while (!que.isEmpty()) {
            Integer[] xy =que.poll();

            for (int i = 0; i < 4; i++) {
                int y_del = xy[0]+dx[i][0];
                int x_del = xy[1]+dx[i][1];

                if(y_del<0 || y_del >=arr.length || x_del<0 || x_del>=arr[0].length|| visited[y_del][x_del]||arr[y_del][x_del]==1) continue;
                if (arr[y_del][x_del] == -1) {
                    attack=true;
                }
                que.add(new Integer[]{y_del, x_del,0});
                visited[y_del][x_del]=true;
                arr[y_del][x_del]= arr[xy[0]][xy[1]]+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //입력값 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    sword_y=i;
                    sword_x=j;
                    arr[i][j]=-1;
                }

            }
        }

        // 필요 변수 선언
        visited = new boolean[N][M];
        attack =false;
        dx = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        que = new ArrayDeque<>();


        BFS(0,0);



        int min =arr[N-1][M-1];
        int sword = arr[sword_y][sword_x]+N-1-sword_y+M-1-sword_x;

        if (attack) {
            if (min == 0) {
                min =sword;
            }
            else if(min>sword){
                min = sword;
            }

            if (min > T) {
                System.out.println("Fail");
            } else {
                System.out.println(min);
            }
        } else {
            if (min == 0) {
                System.out.println("Fail");
            } else {
                if (min > T) {
                    System.out.println("Fail");
                }else{
                    System.out.println(min);
                }
            }
        }

    }
}
/*
BFS로 전체 경로 탐색
탐색도중 2를 만날경우 좌표를 미리 추출
BFS 이후 좌표를 기준으로 최단경로 계산후 일반값과 비교
탑색후 N,M 좌표의 값이 시간보다 초과시 Fail
 */
