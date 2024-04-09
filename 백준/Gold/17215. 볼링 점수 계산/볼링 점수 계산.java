import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++) {
            if (s.charAt(i) == 'S') {
                arr[i] = 10;
            } else if (s.charAt(i) == 'P') {

                arr[i]=10-arr[i-1];
            } else if (s.charAt(i) == '-') {
                arr[i] = 0;
            } else {
                arr[i]= Integer.parseInt(String.valueOf(s.charAt(i)));
            }

        }

        int score =0;
        int frame =0;
        boolean check = false;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(frame==9)break;
            if (s.charAt(i) == 'S') {
                score+=arr[i];
                check = false;
                if(i+1>=arr.length)continue;
                score+=arr[i+1];
                if(i+2>=arr.length)continue;
                score+=arr[i+2];
                frame ++;

            } else if (s.charAt(i) == 'P') {
                score += arr[i];
                check = false;
                if (i + 1 >= arr.length) continue;
                score += arr[i + 1];
                frame++;

            } else {
                if (check) {
                    check = false;
                    frame++;
                    score += arr[i];
                }else {
                    check = true;
                    score += arr[i];
                }
            }
            idx = i;
        }

        for (int i = idx+1; i < arr.length; i++) {
            score+=arr[i];
        }
        System.out.println(score);


    }
}