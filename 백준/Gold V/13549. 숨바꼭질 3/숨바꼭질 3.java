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

    static Queue<Integer[]>que;
    static boolean[] visited;
    static int end;
    static int min = Integer.MAX_VALUE;
    static int max = 100000;
    static void BFS(int start, int time) {
        que.add(new Integer[]{start,time});
        visited[start]=true;
        while (!que.isEmpty()) {
            Integer[] X = que.poll();

            if (X[0] == end) {
                if (min > X[1]) {
                    min=X[1];
                }
                return;
            }
            if (X[0] * 2 <= max && !visited[X[0]*2]) {
                que.add(new Integer[]{X[0]*2,X[1]});
                visited[X[0]*2]=true;
            }
            if (X[0]-1>=0 && !visited[X[0]-1]) {
                que.add(new Integer[]{X[0]-1,X[1]+1});
                visited[X[0]-1]=true;
            }
            if (X[0] + 1 <= max && !visited[X[0]+1]) {
                que.add(new Integer[]{X[0]+1,X[1]+1});
                visited[X[0]+1]=true;
            }



        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 최단 경로 체크 위한 큐, 방문배열 생성
        que = new ArrayDeque<>();
        visited = new boolean[100000+1];


        BFS(start,0);

        System.out.println(min);

    }
}
/*
최단 경로 탑색을 위해 가장먼저 시간이 0초인 2배를 해준다
Queue에 쌓는 순서는 +1 보다 -1을 먼저 쌓아야 한다
-1 에서 2배되는 숫자와 +1에서 +1이 되는 범위가 겹칠경우 뒤에 최단 경로를 탐색하지 못함
 */