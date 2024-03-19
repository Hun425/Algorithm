
import java.util.*;
import java.io.*;
public class Main {
    static int ans,goal;

    static void TPsort(List<Integer>[] arr, int[] time, int[] indegree,int[]result) {
        Queue<Integer[]> que = new LinkedList<>();

        int idx = 0;
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result[i]=time[i];
                que.add(new Integer[]{i, time[i]});
            }
        }

        while (!que.isEmpty()) {
            Integer[] now = que.poll();


            for (Integer i : arr[now[0]]) {
                indegree[i]--;

                result[i] = Math.max(result[i],now[1] + time[i]);
                if (indegree[i] == 0) {
                    que.add(new Integer[]{i, result[i]});
                }
            }

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//건물 개수
            int M = Integer.parseInt(st.nextToken());//건설 규칙 개수

            int[]time = new int[N+1];//건물별 걸리는 시간
            int[]indegree= new int[N+1];
            int[]result = new int[N+1];
            List<Integer>[] arr = new List[N+1];//건설 규칙 인접리스트

            st= new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                time[i]= Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N+1; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i <M ; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                arr[first].add(second);
                indegree[second]++;
            }
            goal = Integer.parseInt(br.readLine());

            TPsort(arr,time,indegree,result);
            ans=0;
            sb.append(result[goal]).append("\n");

        }
        System.out.println(sb);
    }
}
