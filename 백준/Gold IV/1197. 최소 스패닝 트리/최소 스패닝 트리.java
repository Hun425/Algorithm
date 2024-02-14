

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
class Edge {  // Edge 클래스 생성  
    int node1;
    int node2;
    int weight;
    public Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }



}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;   // 유니온 파인드 배열  

    static PriorityQueue<Edge> que; // 노드를 담을 우선순위 큐 생성
    static int ans,cnt;
    static void Union(int a, int b) { // 유니온 파인드의 유니온  
        a = Find(a);
        b = Find(b);

        if (a != b) {
            arr[b]=a;
        }
    }

    static int Find(int a) {  // 유니온 파인드의 파인드  
        if (a == arr[a]) {
            return a;
        }
        else{
            return arr[a]=Find(arr[a]);
        }
    }


    public static void main(String[] args) throws IOException {
        // 입력값 받기  
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 노드수
        int E = Integer.parseInt(st.nextToken()); // 에지수

        arr = new int[V+1]; // 1부터 시작하므로 +1
        for (int i = 1; i < V+1; i++) {
            arr[i]=i;
        }
        que = new PriorityQueue<>(Comparator.comparing(edge -> edge.weight));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            que.add(new Edge(a,b,c));
        }

        int useEdge =0;
        int result =0;

        while (useEdge <V-1) {
            Edge now = que.poll();

            if (Find(now.node1) != Find(now.node2)) {
                Union(now.node1, now.node2);
                result +=now.weight;
                useEdge++;
            }

        }

        System.out.println(result);




    }
}  
  
/*  
문제 조건 == MST를 구현하고 트리의 가중치를 구해라  
 */
