import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long  [] arr =new long[N];

        StringTokenizer st =new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int s = 0;
        int e =N-1;
        long v = Integer.MAX_VALUE;
        int s_idx = 0;
        int e_idx = 0;
        boolean check = false;
        while(s<e){
            long now = arr[s]+arr[e];


            if(now==0){
                check = true;
                System.out.println(arr[s]+" "+arr[e]);
                break;
            }

            else if (now<0){


                if(Math.abs(v)>Math.abs(now)){
                    s_idx = s;
                    e_idx = e;
                    v = Math.abs(now);
                }
                s++;
            }
            else if(now>0){
                if(Math.abs(v)>Math.abs(now)){
                    s_idx = s;
                    e_idx = e;
                    v = Math.abs(now);
                }
                e--;

            }
        }

        if(!check) System.out.println(arr[s_idx]+" "+arr[e_idx]);

    }
}