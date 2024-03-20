
import java.util.*;
import java.io.*;
public class Solution {
    static int ans;

    static void DFS(int level,int[] arr,int goal,int sum,int start) {

        if (level>=1) {
            if (sum >= goal) {
                ans = Math.min(ans,sum-goal);
            }
        }
        if (level == arr.length) {
            return;
        }



        for (int i = start; i < arr.length; i++) {


            DFS(level+1,arr,goal,sum+arr[i],i+1);

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC+1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            ans =Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            DFS(0,arr,goal,0,0);

            System.out.println("#"+(t)+" "+ans);
        }

    }
}
