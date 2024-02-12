import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
    int dt;
    int weight;

    public Edge(int dt, int weight) {
        this.dt = dt;
        this.weight = weight;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Edge> list[];
    static int[] distance ;
    static void Dijkstra(int start) {  // 다익스트라 알고리즘 선언
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge->Edge.weight)); // 가중치가 낮은 순으로 정렬 되도록 선언
        pq.offer(new Edge(start, 0)); // 시작 간선은 가중치 0
        distance[start] =0; // 시작하는 곳의 거리 초기화

        while (!pq.isEmpty()) {  // 여기서 부턴 BFS와 비슷함
            Edge now = pq.poll();

            // 현재 정점과 연결된 간선들 확인
            for (Edge next : list[now.dt]) {
                int nextDistance = distance[now.dt]+next.weight;  // 다음 갈곳 가중치와 현재있는곳 가중치 더함

                if (nextDistance < distance[next.dt]) { // 다음 갈곳의 가중치가 현재 거리 배열값보다 작다면 갱신
                    distance[next.dt] = nextDistance;
                    pq.offer(new Edge(next.dt,nextDistance)); // 그리고 그 가중치를 가지고 큐에 넣기
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        // 입력 값 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 개수(노드최대값)
        int M = Integer.parseInt(st.nextToken()); // 도로 개수(노드개수)
        int K = Integer.parseInt(st.nextToken()); // 거리 정보(찾아야 하는 거리 값)
        int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        list = new ArrayList[N+1];  // 인접 리스트 선언
        distance = new int[N + 1];  // 최소 거리 배열 선언

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<Edge>(); // 인접 리스트 초기화
            distance[i]=Integer.MAX_VALUE;  // 거리 배열 최대값으로 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            list[y].add(new Edge(x,1));  // 노드 간선 인접 리스트에 추가
        }
        Dijkstra(X);
        int cnt=0;
        for (int i = 0; i < N + 1; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println(-1);
        }




    }
}
