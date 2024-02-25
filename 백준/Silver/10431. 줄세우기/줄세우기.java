
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < arr.length; i++) {
                int target = arr[i];
                int j = i - 1;
                while (j >= 0 && target < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                    cnt++;
                }
                arr[j + 1] = target;


            }
            System.out.println((t+1)+" "+cnt);
            cnt=0;
        }
    }
}
