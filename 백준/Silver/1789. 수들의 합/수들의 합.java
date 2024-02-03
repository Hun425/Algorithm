import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited ;
    static int[]print;
    static int[]current;
    static long cnt;
    static Stack<String> stack;
    static void DFS(int start,int level,String N){
        if(level==start){
            for (int i = 0; i < current.length-1; i++) {
                if(Math.abs(current[i]-current[i+1])>3){
                    return;
                }
            }
            cnt++;
            return;
        }
            for (int i = 0; i < print.length; i++) {
                    current[start] = print[i];
                    DFS(start + 1, level,N);
            }
    }


    public static void main(String[] args) throws IOException {
        long sum =0;
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long k = 1;
        while(sum<=N){
            sum+=k;
            k++;
            cnt++;
        }

        System.out.println(cnt-1);

    }
}