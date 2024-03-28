
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC+1; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());//교차로
            int m = Integer.parseInt(st.nextToken());//도로
            int k = Integer.parseInt(st.nextToken());//목적지 후보 개수

            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());//출발지
            int g = Integer.parseInt(st.nextToken());//필수 다리
            int h = Integer.parseInt(st.nextToken());//필수 다리

            List<Edge>[] arr = new List[n+1];

            int[]Min = new int[n+1];
            int[]Min2 = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                arr[i] = new ArrayList<Edge>();
            }

            for (int i = 0; i < n + 1; i++) {
                Min[i]=Integer.MAX_VALUE;
                Min2[i]=Integer.MAX_VALUE;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                arr[first].add(new Edge(second,weight));
                arr[second].add(new Edge(first,weight));

            }
            Dijkstra(s,arr,Min);
            int idx = 0;
            if (Min[g] > Min[h]) {
                Dijkstra(g, arr, Min2);
                idx = g;
            } else {
                Dijkstra(h,arr,Min2);
                idx = h;
            }

            List<Integer>ans = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                int now = Integer.parseInt(br.readLine());
                if(Min[now]==Min2[now]+Min[idx])ans.add(now);
            }
            Collections.sort(ans);
            for (Integer an : ans) {
                sb.append(an).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    static void Dijkstra(int s,List<Edge>[] arr, int[]Min) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) ->o1.weight-o2.weight);

        pq.add(new Edge(s,0));
        Min[s]=0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge edge : arr[now.cdn]) {
                int distance = edge.weight+now.weight;
                if (distance >= Min[edge.cdn])continue;
                Min[edge.cdn] = distance;
                pq.add(new Edge(edge.cdn,distance));

            }
        }

    }

}

class Edge{
    int cdn;
    int weight;

    public Edge(int cdn, int weight) {
        this.cdn = cdn;
        this.weight = weight;
    }
}
