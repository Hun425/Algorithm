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
    static long[] Excute(long a, long b){
        long[] ret = new long[2];
        if (b == 0) {
            ret[0]=1; ret[1]=0;
            return ret;
        }
        long q = a/b;
        long[] v = Excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0]-v[1]*q;
        return ret;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a= b;
            b = temp;
        }
        return Math.abs(a);
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long d0 = a, d1 = n;
        long x0 = 1, x1 = 0;

        while (d1 != 0) {
            long q = d0 / d1;
            long tmp = d0;
            d0 = d1;
            d1 = tmp - q * d1;

            tmp = x0;
            x0 = x1;
            x1 = tmp - q * x1;
        }

        if (d0 == 1) {
            if (x0 <= 0) {
                x0 += n;
            }
            System.out.println((n - a) + " " + x0);
        } else {
            System.out.println((n - a) + " -1");
        }
    }
}
/*
덧셈의 역원은 (A+B)%N = 0  A-B 가 역원 (A가 B보다 크다고 가정)
곱셈의 역원은 (A+C)%N =1 이 만족하면 C는 A의 곱셈역

 */
