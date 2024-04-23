import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer (br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]arr = new int[N];
        int[]dt = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            dt[i] = arr[i+1]-arr[i];
        }
        Arrays.sort(dt);

        int sum =0;
        for (int i = 0; i < N-(M-1); i++) {
            sum+=dt[i];
        }

        System.out.println(sum);


    }
}