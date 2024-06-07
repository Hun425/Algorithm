import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] money = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int idx = n-1;
        while(m>0){
            int v = money[idx];
            if(m-v<0){
                idx--;
                continue;
            }

            int cnt =1;

            while(v<=m){
                int temp = v;
                temp*=cnt;
                if(temp>m)break;
                cnt++;
            }
            cnt--;
            m=m-v*cnt;
            ans+=cnt;
            idx--;
        }

        System.out.println(ans);
    }
}