import java.util.Scanner;

public class Main {
    static int eulerPhi(int n) {
        int euler = n;
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                euler = euler / p * (p - 1);
                while (n % p == 0) n = n / p;
            }
        }
        if (n > 1) euler = euler / n * (n - 1);
        return euler;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = Integer.MAX_VALUE;

        for (int x = 1; x * x <= n; x++) {
            if (n % x == 0) {
                if (eulerPhi(x) == n / x) result = Math.min(result, x);
                if (eulerPhi(n / x) == x) result = Math.min(result, n / x);
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}