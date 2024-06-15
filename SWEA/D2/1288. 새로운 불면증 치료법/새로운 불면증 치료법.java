import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int total = (1<<10)-1; // 비트마스킹 기준값

        StringBuilder sb= new StringBuilder();
        for (int t = 1; t < T+1; t++) {

            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(br.readLine());

            int visited = 0;
            int count= 0;

            while(true){
                count++;
                char[] arr = String.valueOf(N*count).toCharArray();
                for (char c : arr) {
                    int num = c- '0';
                    visited = visited | (1<<num);
                }

                if(visited==total)break;


            }
            sb.append(N*count).append("\n");
        }

        System.out.println(sb);
    }
}