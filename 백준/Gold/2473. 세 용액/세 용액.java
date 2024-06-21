import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 배열을 정렬

        long[] ans = new long[3];
        long minAbsSum = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < minAbsSum) {
                    minAbsSum = Math.abs(sum);
                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        Arrays.sort(ans);

        for (long an : ans) {
            System.out.print(an + " ");
        }
    }
}