import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[366]; //일자 배열 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = s; j <e+1 ; j++) {
                arr[j]++;
            }
        }

        int cnt = 0;
        int result = 0;
        int h = 0;
        for (int i = 1; i < 366; i++) { // 순회하면서 넓이 구하기
            h = Math.max(h,arr[i]);// 중첩 높이 최대값 구하기
            if(arr[i]>=1)cnt++;
            else {
                result += cnt*h;
                cnt=0;
                h=0;
            }

            if(i==365){
                result += cnt*h;
                cnt=0;
                h=0;
            }
        }

        System.out.println(result);
    }
}