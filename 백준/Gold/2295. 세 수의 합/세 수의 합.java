import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        //X = a + b + c
        //X - c = a + b
        Set<Long> twoSum = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j <N ; j++) {
                twoSum.add(arr[i] + arr[j]);
            }
        }

        long result = 0;

        //최댓값을 찾아야 하니깐 뒤에서부터
        for (int i = N-1; i >=0 ; i--) {
            for (int j = i; j >=0 ; j--) {
                if(twoSum.contains(arr[i] - arr[j])){
                    result = arr[i];
                    i=-1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}