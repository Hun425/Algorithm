
import java.util.*;
import java.io.*;
public class Solution {
    static double result;
    static int [] path;
    static boolean[] visited;
    static void DFS(int level, int N,int[][]person  ,double sum) {
        if (sum <= result) {
            return;
        }
        if (level == N) {

            result= Math.max(result,sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i])continue;
            visited[i]=true;
            path[level]=i;
            DFS(level+1,N,person,sum*person[level][path[level]]*0.01);
            visited[i]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC+1; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(br.readLine());

            int[][]person = new int[N][N];
            path = new int[N];
            visited = new boolean[N];
            result = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st= new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    person[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DFS(0,N,person,100);
            sb.append(String.format("%.6f",result));
            System.out.println(sb);
        }
    }
}
