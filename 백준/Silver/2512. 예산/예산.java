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
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 입력값 받기
        int [] arr = new int[N];
        long end = 0;
        long start  =0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end,arr[i]);
        }
        st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());

        // 파라메트릭 서치 사용

        while (start <= end) {
            long mid = (start+end)/2;
            long sum_arr=0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    sum_arr +=mid ;
                }
                else{
                    sum_arr+=arr[i];
                }
            }
            if(max<sum_arr){
                end= mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(end);



    }
}