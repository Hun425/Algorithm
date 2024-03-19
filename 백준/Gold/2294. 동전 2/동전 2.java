
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[]arr = new int[N+1];
        int[]ans = new int[goal+1];

        for (int i = 1; i <N+1 ; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < goal+1; i++) {
            ans[i] = Integer.MAX_VALUE/2;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = arr[i]; j < goal+1; j++) {
                int idx = j-arr[i];
                ans[j] =Math.min(ans[idx]+1,ans[j]);
            }
        }
        if (ans[goal] >= Integer.MAX_VALUE/2) {
            System.out.println(-1);
        } else {
            System.out.println(ans[goal]);
        }

    }
}
