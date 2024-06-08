import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt =0;

        while(N>=1000){ // 1000개 개수 측정
            N-=1000;
            cnt+=1;
        }


        System.out.println(1999);


        for (int i = 0; i < 999; i++) {
            sb.append(1).append(" ");
        }

        for (int i = 0; i < 1000; i++) {
            sb.append(1000).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}