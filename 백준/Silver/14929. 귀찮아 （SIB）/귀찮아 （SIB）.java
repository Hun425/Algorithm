import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // x1*(x2+x3...xn)
        // x2*(x3+x4...xn)



        // 배열 숫자 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 배열 순서대로 집어넣기
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 배열을 가지고 합배열 만들기
        int[] sum = new int[N];
        int s = 0;
        for (int i = 0; i < N; i++) {
            s +=arr[i];
            sum[i]= s;
        }

        // 기존 배열 n-1까지 합 배열과 곱해서 더하기
        long ans =0;
        for (int i = 0; i < N-1; i++) {
            ans += arr[i]*(sum[N-1]-sum[i]);
        }
        // 값 출력
        System.out.println(ans);
    }
}
