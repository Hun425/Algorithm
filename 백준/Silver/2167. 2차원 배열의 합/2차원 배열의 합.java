import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.nio.channels.SelectionKey;
import java.util.*;
import java.util.ArrayList;

public class Main {
    static String bbq(int[]arr,int index){

        if (index<arr.length) {
            System.out.print(arr[index]+" ");

            return bbq(arr,index+1);
        }
        else{
            return"";
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int j = y1-1; j <y2 ; j++) {
                for (int k = x1-1; k < x2; k++) {
                    sum+=arr[j][k];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}

