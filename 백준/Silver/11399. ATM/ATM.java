

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        int now =0;
        for (int i = 0; i < N; i++) {
            now += arr[i];
            ans+=now;
        }

        System.out.println(ans);


    }
}
