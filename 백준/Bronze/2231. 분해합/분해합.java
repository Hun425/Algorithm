import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int ans = 0;
        while(true){
            String st= String.valueOf(ans);

            int result = 0;

            for (int i = 0; i < st.length(); i++) {
                result+=Integer.parseInt(String.valueOf(st.charAt(i)));
            }
            result += Integer.parseInt(st);

            if(n==result){
                System.out.println(ans);
                break;
            }

            if(ans==n){
                System.out.println(0);
                break;
            }
            ans++;
        }


    }
}