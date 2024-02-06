import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        if (N <=1||N==3) {
            System.out.println(-1);
        }
        else {
            int cnt = 0;
            cnt = N / 5;
            N = N % 5;
            if ((N % 5) % 2 == 1) {
                cnt--;
                N += 5;
            }
            cnt += N / 2;
            System.out.println(cnt);
        }
    }
}