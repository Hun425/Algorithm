import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cnt= 0;
        boolean check = false;
        for (int i = 0; i < M; i++) {
            cnt++;
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(union(s,e,parent)){
                check = true;
                break;
            }

        }

        if(check) System.out.println(cnt);
        else System.out.println(0);
    }
    static int find(int a, int[]parent){
        if(a==parent[a])return a;
        else return parent[a] = find(parent[a],parent);
    }

    static boolean union(int a, int b, int[]parent){
        a = find(a,parent);
        b = find(b,parent);

        if(a!=b){
            parent[b] = a;
            return false;
        }
        else return true;
    }
}