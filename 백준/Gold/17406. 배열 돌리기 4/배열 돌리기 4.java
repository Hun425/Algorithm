import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int ans;
    static boolean[] visited;
    static void rotation(int r, int c, int s, int[][]arr) {
        int y = r-s;
        int x = c-s;
        int N = (r+s)-(r-s);
        int cnt =0;
        while (cnt < N/2) {
            int temp = arr[y-1+cnt][x-1+cnt];
            for (int i = 0; i < N-cnt*2; i++) {
                arr[r-s-1+i+cnt][c-s-1+cnt]= arr[r-s+i+cnt][c-s-1+cnt];
            }
            for (int i = 0; i < N -cnt*2; i++) {
                arr[r+s-1-cnt][c-s+i-1+cnt]=arr[r+s-1-cnt][c-s+i+cnt];
            }
            for (int i = 0; i < N -cnt*2; i++) {
                arr[r+s-i-1-cnt][c+s-1-cnt]=arr[r+s-i-2-cnt][c+s-1-cnt];
            }
            for (int i = 0; i < N -cnt*2-1; i++) {
                arr[r-s-1+cnt][c+s-i-1-cnt]=arr[r-s-1+cnt][c+s-i-2-cnt];
            }
            arr[y-1+cnt][x+cnt]=temp;
            cnt++;
        }

    }
    static int min_sum(int[][] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum =0;
            for (int j = 0; j < arr[i].length; j++) {
                sum+=arr[i][j];
            }
            min = Math.min(sum, min);
        }
        return min;
    }

    static void DFS(int level, int K, int[][]arr,int[][]path,int[][]rot) {

        if (level == K) {
            int[][] backup = new int[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    backup[i][j]=arr[i][j];
                }
            }
            for (int i = 0; i < path.length; i++) {
                int r = path[i][0];
                int c = path[i][1];
                int s = path[i][2];
                rotation(r,c,s,backup);
            }
            int result = min_sum(backup);
            ans = Math.min(result, ans);
            return;
        }


        for (int i = 0; i < K; i++) {
            if(visited[i])continue;
            visited[i]=true;
            for (int j = 0; j < 3; j++) {
                path[level][j]=rot[i][j];
            }
            DFS(level+1,K,arr,path,rot);
            visited[i]=false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 회전 개수
        int[][] arr= new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] rot = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rot[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited= new boolean[K];
        int [][]path = new int[K][3];

        ans = Integer.MAX_VALUE;
        DFS(0, K, arr, path, rot);


        System.out.println(ans);
    }
}
/*
    1. 메서드화 시키기
    2. 전역변수 남발하지 않기
    3. 변수명 알기쉽게하기
    4. 주석 잘 달기
    5. **설계 꼼꼼하게 하기**
 */

