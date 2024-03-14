import java.util.*;
import java.io.*;

public class Main {
    static long cnt,N;
    static double water;

    static void DFS(int start,List<Integer>[] graph, boolean[]visited) {


        for (Integer i : graph[start]) {
            if(visited[i])continue;
            visited[i]=true;
            DFS(i,graph,visited);
            cnt++;

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        water = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[(int)N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean [] visited = new boolean[(int)N+1];
        visited[1]=true;

        double count = 0;
        for (int i = 2; i < graph.length; i++) {
            if(graph[i].size()==1)count++;
        }

        double ans = water;


        System.out.printf("%.6f",water/count);

    }
}
