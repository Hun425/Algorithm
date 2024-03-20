
import java.util.*;
import java.io.*;
public class Main {
    static int N,cnt;
    static boolean[] visited;

    static boolean check(int[] arr,int col) {
        for (int i = 0; i < col; i++) {
            if(Math.abs(col-i)==Math.abs(arr[col]-arr[i]))return false;
        }
        return true;
    }

    static void DFS(int level,int[]arr) {


        if (level == N) {
            cnt++;
            return;
        }

        for (int i =0; i < N; i++) {
            if(visited[i])continue;
            arr[level]= i;
            visited[i]=true;
            if (check(arr, level)) {
                DFS(level+1,arr);
            }
            visited[i]=false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];// index가 열이고 value가 행을 뜻함
        visited = new boolean[N];

        DFS(0,arr);

        System.out.println(cnt);


    }
}
