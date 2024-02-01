import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static void DFS(int N,int M,int count ){
    int lv;
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.println(cnt[i]);
            }
        }
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                cnt[count]=i;
                visited[i]=true;
                DFS(N,M,count+1);
                visited[i]=false;
            }
        }
    }
    static int[] cnt ;
    static boolean []visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        cnt = new int[N+1];
        DFS(N,M,0);



    }
}