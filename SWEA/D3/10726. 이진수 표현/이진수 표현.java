import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();

        for (int t = 1; t< T+1; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int V = (1<<N)-1;

            if(V==(V&M))sb.append("ON").append("\n");
            else sb.append("OFF").append("\n");
        }
        System.out.println(sb);
    }
}