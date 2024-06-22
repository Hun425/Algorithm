import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }


        int cnt = 0;
        int s = 0;
        int e = 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        while(s<N && e<N+1 ){

            if(sum<M ){
                if(e==N)break;
                sum += arr[e];
                e++;

                cnt++;
            }
            if(sum>=M){
                ans = Math.min(ans, cnt);
                sum-=arr[s];
                s++;
                cnt--;
            }
        }

        if(ans==Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }
    }
}