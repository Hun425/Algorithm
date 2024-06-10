import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine()); //출발 좌표

        List<int[]>[] cdn = new List[N+1]; // 인접리스트



        for (int i = 0; i < N + 1; i++) { 
            cdn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());//시작좌표
            int e = Integer.parseInt(st.nextToken());//도착좌표
            int v = Integer.parseInt(st.nextToken());//가중치

            cdn[s].add(new int[]{e,v});
        }

        int[] dt= new int[N+1];

        for (int i = 0; i < N + 1; i++) {
            dt[i] = Integer.MAX_VALUE;
        }

        Dijkstra(S,dt,cdn);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <dt.length ; i++) {
            if(dt[i] == Integer.MAX_VALUE)sb.append("INF").append("\n");
            else sb.append(dt[i]).append("\n");
        }

        System.out.println(sb);
    }
    static void Dijkstra(int start,int[] dt,List<int[]>[] cdn){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        
        pq.add(new int[]{start,0});
        dt[start]=0;

        while(!pq.isEmpty()){
            int[]now = pq.poll();

            int e = now[0];
            int v = now[1];
            if(dt[e]<v)continue;

            for (int[] ints : cdn[e]) {
                int next = ints[0];
                int nextValue = ints[1];
                int nowValue = dt[e];
                if(dt[next]<=nowValue+nextValue)continue;
                if(dt[next]>nowValue+nextValue){
                    dt[next]=nowValue+nextValue;
                    pq.add(new int[]{next,nowValue+nextValue});
                }
            }
        }
        
    }
}