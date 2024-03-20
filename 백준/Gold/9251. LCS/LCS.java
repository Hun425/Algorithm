
import java.util.*;
import java.io.*;
public class Main {
    static int ans;
    static void LCS(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] arr = new int[len1+1][len2+1];

        for (int i = 1; i <len1+1 ; i++) {
            for (int j = 1; j < len2+1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
                ans = Math.max(ans,arr[i][j]);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        LCS(s1,s2);

        System.out.println(ans);
    }
}
