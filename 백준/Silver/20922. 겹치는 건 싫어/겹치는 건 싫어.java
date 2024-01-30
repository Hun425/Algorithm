import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static void sum(int[]arr, int []check,int N){
        int mx =0;
        int idx=0;
        for (int i = 0; i < check.length; i++) {
            int sum =0;
            for (int j = i; j <i+N ; j++) {
                sum+=arr[i];
            }
            if (mx < sum) {
                mx=sum;
                idx =i;
            }
        }
        System.out.println(check[idx-1] +" "+ mx);


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        int mx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;

            if(a>mx){
                mx=a;
            }

        }
        int[] check = new int[mx+1];


        int ans =0;
        int m =0;

        int start = 0;
        int end =0;
        int cnt =0;
        int an =0;
        while( end < arr.length){

            if(check[arr[end]]>=M){
                check[arr[start]]-=1;
                cnt--;
                start++;
            }
            else {
                check[arr[end]] += 1;
                cnt++;
                an = Math.max(cnt, an);
                end++;
            }
        }
        System.out.println(an);
}}