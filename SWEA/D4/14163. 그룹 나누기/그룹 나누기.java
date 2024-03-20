
import java.util.*;
import java.io.*;
public class Solution {
    static int[]parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC+1; t++) {
            sb.append("#").append(t).append(" ");

            StringTokenizer st= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//출석번호
            int M = Integer.parseInt(st.nextToken());//그룹 숫자
            parent = new int[N+1];

            for (int i = 0; i < N+1; i++) {
                parent[i]=i;
            }

            st =new StringTokenizer(br.readLine());
            //그룹화
            for (int i = 0; i < M; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                Union(s,e);
            }
            // 그룹부모로 초기화
            for (int i = 0; i < N+1; i++) {
                find(i);
            }
            //그룹 개수카운트
            HashMap<Integer,Integer>map = new HashMap<>();
            for (int i = 1; i <N+1 ; i++) {
                map.put(parent[i], map.getOrDefault(parent[i],0)+1);
            }

            sb.append(map.size()).append("\n");
        }
        System.out.println(sb);
    }
    static void Union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b]=a;
        }
    }
    static int find(int a) {
        if(a==parent[a])return a;
        else return parent[a]=find(parent[a]);
    }
}
