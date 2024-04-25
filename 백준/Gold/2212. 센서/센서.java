import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//센서 개수
        int K = Integer.parseInt(br.readLine());//집중국 개수

        Integer[] arr = new Integer[N];

        int[] sum = new int[N];





        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = 0;
            int now  = Integer.parseInt(st.nextToken());
            arr[i] = now;
        }
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(arr));

        arr = hashSet.toArray(new Integer[0]);
        Arrays.sort(arr);
        int[] dt = new int[arr.length-1];
        for (int i = 0; i <arr.length-1 ; i++) {
            v = arr[i+1]-arr[i];
            dt[i] = v;
        }
        Arrays.sort(dt);

        int result = 0;
        for (int i = 0; i < dt.length-(K-1); i++) {
            result +=dt[i];
        }

        System.out.println(result);
    }
}