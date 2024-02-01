import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static void DFS(int N,int M,int count ){

        if (count == M) {

            for (int i = 0; i < M; i++) {

                    sb.append(cnt[i]).append(" ");

            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i < N+1; i++) {


                cnt[count]=i;


                DFS(N,M,count+1);


        }
    }
    static int nt=1;
    static int[] cnt ;
    static boolean []visited;
    static   StringBuilder sb;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        cnt = new int[N+1];
        DFS(N,M,0);

        System.out.println(sb);

    }
}