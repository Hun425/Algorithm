import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] ans = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans[arr[i]]=0;
        }


        for (int i = 0; i < N; i++) {
            for (int j = arr[i]*2; j < ans.length; j+=arr[i]) {
                if(ans[j]!=Integer.MIN_VALUE){
                    ans[j]--;
                    ans[arr[i]]++;
                }
            }
        }

        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(ans[arr[i]]+" ");
        }

        System.out.println(sb);
    }
}