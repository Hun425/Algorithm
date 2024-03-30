
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] Indegree = new int[N + 1];
            int[] arr = new int[N+1];
            List<Integer>[] cdn = new List[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N + 1; i++) {
                cdn[i] = new ArrayList<>();
            }

            for (int i = 1; i < N+1; i++) {
                int from = arr[i];
                for (int j = i+1; j < N+1; j++) {
                    int plus = arr[j];
                    cdn[from].add(arr[j]);
                    Indegree[arr[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());

            int value = N;





            Queue<Integer>que = new ArrayDeque<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                TPsort(que,cdn,Indegree,s,e);
            }

            int cnt =0;
            for (int i = 1; i < N+1; i++) {
                if (Indegree[i] == 0) {
                    que.add(i);
                    cnt++;
                }
            }

            if (cnt > 1) {
                sb.append("?").append("\n");
                System.out.println(cnt);
                continue;
            }

            boolean check = false;
            StringBuilder sb2= new StringBuilder();

            for (int i = 1; i < N+1; i++) {
                if (que.isEmpty()) {
                    sb.append("IMPOSSIBLE").append("\n");
                    check = true;
                    break;
                }
                int now = que.poll();
                sb2.append(now).append(" ");
                for (Integer integer : cdn[now]) {

                    Indegree[integer]--;

                    if (Indegree[integer] == 0) {
                        que.add(integer);
                    }
                }
            }
            if(check)continue;

            sb.append(sb2).append("\n");
        }
        System.out.println(sb);

    }
    static void TPsort(Queue<Integer> que,List<Integer>[] cdn, int[]Indegree,int s,int e ){

            if (cdn[s].contains(e)) {
                cdn[s].remove((Integer)e);
                cdn[e].add(s);
                Indegree[s]++;
                Indegree[e]--;
            } else {
                cdn[e].remove((Integer)s);
                cdn[s].add(e);
                Indegree[s]--;
                Indegree[e]++;
            }


    }


}
