import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); //교통비
        int N = Integer.parseInt(br.readLine()); //도시의 개수
        int R = Integer.parseInt(br.readLine()); //도로의 개수

        List<int[]>[] arr = new List[N+1]; //0은 사용하지 않음

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        int max = 0;
        for (int i = 0; i < R; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); //출발 도시
            int e = Integer.parseInt(st.nextToken()); //도착 도시
            int dt = Integer.parseInt(st.nextToken()); //도시간의 거리
            int v = Integer.parseInt(st.nextToken()); //해당 도로의 통행료
            max = Math.max(max,v);
            arr[s].add(new int[]{e,dt,v});
        }

        int[][] dt = new int[N+1][K+1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dt[i][j] =Integer.MAX_VALUE;
            }
        }

        Dijkstra(1,dt,arr,K);

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <K+1 ; i++) {
            ans = Math.min(ans,dt[N][i]);
        }
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    static void Dijkstra(int start,int[][]dt,List<int[]>[]arr,int max) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{start,0,0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int nowDt = temp[1];
            int nowV = temp[2];
            if(nowV>max)continue;

            for (int[] ints : arr[temp[0]]) {
                int e = ints[0]; // 목적지
                int distance = ints[1]; //거리
                int v = ints[2]; // 통행료
                int nextDt = nowDt + distance;
                int nextV = nowV+v;
                if(nextV>max)continue;

                if(dt[e][nextV]>nextDt){
                    dt[e][nextV] = nextDt;
                    pq.add(new int[]{e,distance+nowDt,nextV});
                }
            }


        }

    }
}