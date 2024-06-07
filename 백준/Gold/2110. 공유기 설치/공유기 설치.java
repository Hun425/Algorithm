import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] arr =new int[N]; // 집 좌표

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s = 0;

        int e = arr[N-1]-arr[0]+1;// 최대 거리를 찾아야 하기 때문에 Upper Bound, 최대의 차이가 정답일수도 있으므로 +1
        int mid = 0;
        int ans = 0;
        while(s<=e){
            mid = (s+e)/2;

            if(count(mid,M,arr)) {
                ans = mid;
                s = mid+1;
            }
            else e= mid-1;


        }

        System.out.println(ans);
    }

    static boolean count(int mid,int M,int[]arr){
        int cnt = 0;

        int dt = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]-dt>=mid){
                dt = arr[i+1];
                cnt++;
            }

            if(cnt>=M-1) return true;
        }

        return false;
    }
}