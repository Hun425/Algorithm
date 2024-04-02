
import java.io.*;
import java.util.*;
public class Main {
    static int cnt,min,max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );


        String s = br.readLine();

        char[] arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        int[]path = new int[2];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        play(s,0);


        System.out.println(min+" "+max);
    }

    static void play(String s,int sum) {
        if (s.length() <= 2) {
            cnt=0;
            count(0, 0, s);
            sum+=cnt;
            min = Math.min(min,sum);
            max = Math.max(max,sum);

            return;
        }

        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length()-1; j++) {
                String temp = s;
                cnt=0;
                temp = count(i,j,temp);
                play(temp,sum+cnt);

            }
        }
    }

    static String count(int a, int b,String s) {

        String first = "";
        String second = "";
        String third = "";


        boolean check = false;
            if (s.length() == 1) {
                if(s.charAt(0)%2==1)cnt++;
                return s;
            }
            if (s.length() <= 2) {
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)%2==1)cnt++;
                }
                int result = Integer.parseInt(String.valueOf(s.charAt(0)))+Integer.parseInt(String.valueOf(s.charAt(1)));


                s= String.valueOf(result);
                count(0,0,s);

                return s;
            }
            for (int i = 0; i < a+1; i++) {
                if(s.charAt(i)%2==1)cnt++;
                first += String.valueOf(s.charAt(i));
            }
            for (int i = a+1; i <b+1 ; i++) {
                if(s.charAt(i)%2==1)cnt++;
                second += String.valueOf(s.charAt(i));
            }
            for (int i = b+1; i <s.length() ; i++) {
                if(s.charAt(i)%2==1)cnt++;
                third +=String.valueOf(s.charAt(i));
            }
            int result = Integer.parseInt(first)+Integer.parseInt(second)+Integer.parseInt(third);
            s = String.valueOf(result);
            return s;
        }


}

