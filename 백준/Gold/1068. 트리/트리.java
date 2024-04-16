import java.util.*;
import java.io.*;

public class Main {
    static int cnt,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int s = 0;
        int[] arr = new int[N];
        boolean[] visited = new boolean[N+1];
        List<Integer>[] cdn= new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            cdn[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;
            if(arr[i]==-1){
                s = i;
                continue;
            }
            cdn[v].add(i);
        }

        int remove = Integer.parseInt(br.readLine());
        visited[remove] = true;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < cdn[i].size(); j++) {
                if(cdn[i].get(j)==remove)cdn[i].remove(j);
            }
        }

        DFS_visited(remove,cdn,visited);

        DFS_count(s,cdn,visited);

        System.out.println(cnt);
    }
    static void DFS_visited(int s,List<Integer>[]cdn, boolean[]visited){
        visited[s]=true;
        for (Integer i : cdn[s]) {

            DFS_visited(i,cdn,visited);
        }

    }

    static void DFS_count(int s, List<Integer>[]cdn, boolean[]visited){
        if(visited[s])return;
        if(cdn[s].isEmpty())cnt++;

        for (Integer i : cdn[s]) {

            DFS_count(i,cdn,visited);
        }
    }
}