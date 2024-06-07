import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0) break;

            int[]arr = new int[3];

            arr[0] = a;
            arr[1] = b;
            arr[2] = c;

            Arrays.sort(arr);

            if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2]) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}