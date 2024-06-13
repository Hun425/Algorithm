import java.util.*;
import java.io.*;

public class Main {
    static int ans, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<int[]>[] cdn = new List[N + 1];
        List<int[]>[] cdn2 = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            cdn[i] = new ArrayList<>();
            cdn2[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cdn[s].add(new int[]{e, w}); // 인접리스트 생성
            cdn2[e].add(new int[]{s, w});
        }

        int[] dt = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dt[i] = Integer.MAX_VALUE/2;
        }
        Dijkstra(cdn, X, dt);


        int[] dt2 = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dt2[i] = Integer.MAX_VALUE/2;
        }
        Dijkstra(cdn2, X, dt2);

        for (int i = 1; i < N + 1; i++) {
            result = Math.max(dt[i] + dt2[i], result);
        }

        System.out.println(result);

    }

    static void Dijkstra(List<int[]>[] cdn, int s, int[] dt) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.add(new int[]{s, 0});

        dt[s]=0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int now_cdn = now[0];
            int now_dt = now[1];

            for (int[] ints : cdn[now_cdn]) {
                int next_cdn = ints[0];
                int next_dt = ints[1];


                if (dt[now_cdn] + next_dt < dt[next_cdn]) {
                    dt[next_cdn] = dt[now_cdn] + next_dt;
                    pq.add(new int[]{next_cdn, dt[next_cdn]});
                }
            }
        }


    }
}