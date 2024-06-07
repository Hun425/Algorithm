import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();

            if(s.equals("0")) break;

            int[]arr = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - '0';
            }
            int[] arr2 = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[arr.length - 1 - i];
            }

            if(Arrays.equals(arr, arr2)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}