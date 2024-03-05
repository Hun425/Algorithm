
import java.util.*;
import java.io.*;
public class Main {
    static boolean check;
    static boolean []visited;
    static void DFS(int start,int find,int cnt,List<Integer>[] Person) {
        if (start == find) {
            System.out.println(cnt);
            check=true;
            return;
        }

        for (int person : Person[start]) {
            if(visited[person])continue;
            visited[person]=true;
            DFS(person,find,cnt+1,Person);
            visited[person]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//전체 사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());//출발지점
        int end = Integer.parseInt(st.nextToken());//도착지점

        int M = Integer.parseInt(br.readLine());//간선 개수

        List<Integer>[] Person = new List[N];

        for (int i = 0; i < N; i++) {
            Person[i]= new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;
            
            Person[first].add(second);
            Person[second].add(first);
        }

        check = false;
        visited= new boolean[N];
        DFS(start-1,end-1,0,Person);

        if (!check) {
            System.out.println(-1);
        }

    }
}
