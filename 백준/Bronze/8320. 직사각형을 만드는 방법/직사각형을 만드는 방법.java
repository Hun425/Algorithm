import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean check1, check2;
    static boolean Babygin1(int[] arr,boolean check) {
        int [] DAT = new int[10];

        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i]==-1)continue;
            DAT[arr[i]]++;
        }
        for (int i = 0; i < DAT.length; i++) {
            if (DAT[i] >= 3) {
                check = true;
                return check;

            }
        }
        return check;
    }
    static boolean Babygin2(int[] arr,boolean check) {

        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i]==-1)continue;
            if (arr[i] == arr[i + 1] + 1 ) {
                if (arr[i + 1] == arr[i + 2] + 1) {
                    check = true;
                    return check;
                }
            } else if (arr[i] == arr[i + 1] - 1) {
                if (arr[i + 1] == arr[i + 2] - 1) {
                    check =true;
                    return check;
                }
            }
        }

        return check;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = i; j < N+1; j++) {
                if(i*j<=N)result++;
            }
        }
        System.out.println(result);
    }
}