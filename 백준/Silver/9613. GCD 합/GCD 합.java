import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int GCD(int A, int B) {
        if (A > B) {
            if (A == 0) {
                return B;
            }
            if (B == 0) {
                return A;
            }
            int R = A / B;

            return GCD(B, A - B * R);
        } else {
            int temp = A;
            A = B;
            B = temp;
            
            if (A == 0) {
                return B;
            }
            if (B == 0) {
                return A;
            }
            int R = A / B;

            return GCD(B, A - B * R);
        }


    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int [] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum =0;
            for (int j = 0; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    sum+=GCD(arr[j],arr[k]);
                }
            }
            System.out.println(sum);
        }

    }
}
/*
유클리드 호제법 GCD(A,B) = GCD(B,A-B*R)
모든 구간을 브루트 포스 하면서 유클리드 호제법 결과값 합산하기
 */
