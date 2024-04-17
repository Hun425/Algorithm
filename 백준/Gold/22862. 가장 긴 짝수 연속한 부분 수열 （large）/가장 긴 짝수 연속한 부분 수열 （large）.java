import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력값 받기
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        // 슬라이딩 윈도우 준비
        int cnt= 0;
        int ans = 0;
        int s =0;
        int e = 1;

        if(arr[0]%2==1)cnt++;
        else ans=1;
        while(e<arr.length && s<arr.length){
            if(cnt>K){
                while(cnt>K){
                    if(arr[s]%2==1)cnt--;
                    s++;
                    if(s==arr.length)break;
                    ans= Math.max(e-s-cnt,ans);
                }
            }else{
                int dt = e-s;
                if(arr[e]%2==1)cnt++;

                e++;
                ans= Math.max(e-s-cnt,ans);
            }
        }
        System.out.println(ans);
    }
}