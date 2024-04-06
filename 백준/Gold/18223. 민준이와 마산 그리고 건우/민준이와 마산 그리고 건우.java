import java.util.*;
import java.io.*;
public class Main {
    static boolean check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());//정점의 개수
        int E = Integer.parseInt(st.nextToken());//간선의 개수
        int P = Integer.parseInt(st.nextToken());//건우의 위치

        List<Integer[]>[] cdn = new List[V+1];//인접리스트
        int [] arr = new int[V+1];//다익스트라 배열
        int [] arr2 = new int[V+1];//민준이 기준 배열
        check = false;

        for (int i = 0; i < V + 1; i++) {
            cdn[i] = new ArrayList<>();//인접 리스트 선언
            arr[i] = Integer.MAX_VALUE;
            arr2[i]= Integer.MAX_VALUE;
        }
        arr[1]=0;
        arr2[P]=0;
        for (int i = 0; i < E; i++) {
            st= new StringTokenizer(br.readLine());//입력값 받기

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            cdn[s].add(new Integer[]{e,v});
            cdn[e].add(new Integer[]{s,v});
        }

        Dijkstra(1,cdn,arr,P);
        Dijkstra(P,cdn,arr2,P);
        if (arr[V]==arr[P]+arr2[V]) {
            System.out.println("SAVE HIM");
        }else System.out.println("GOOD BYE");

    }
    static void Dijkstra(int s,List<Integer[]>[] cdn,int[]arr, int P) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        pq.add(new Integer[]{s,0});

        while (!pq.isEmpty()) {
            Integer[] now = pq.poll();

            for (int i = 0; i < cdn[now[0]].size(); i++) {
                int next  = cdn[now[0]].get(i)[0];
                int next_value = cdn[now[0]].get(i)[1];

                if(arr[next]<cdn[now[0]].get(i)[1]+arr[now[0]])continue;

                arr[next]=cdn[now[0]].get(i)[1]+arr[now[0]];
                pq.add(new Integer[]{next,next_value});

            }

        }


    }
}