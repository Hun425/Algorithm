import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();


        boolean samecheck = true;
        char[]s = new char[string.length()];
        char x = string.charAt(0);
        for (int i = 0; i < string.length(); i++) {
            s[i] = string.charAt(i);
            if(x!=s[i]) samecheck = false;
        }




        char[]reverse = new char[string.length()];

        int idx =0;
        for(int i =string.length()-1;i>=0;i--){
            reverse[idx++]=s[i];
        }

        int ans =0;

        int cnt = s.length;
        boolean check = false;
        boolean startcheck = true;
        for (int i = 0; i <s.length ; i++) {
            if (s[i] != reverse[i]) {
                startcheck = false;
                break;
            }
        }


        if(startcheck) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] == reverse[i]) {
                    continue;
                } else {
                    check = true;
                    break;
                }
            }
        }
        ans = Math.max(cnt,ans);

        if(samecheck) System.out.println(-1);
        else if(!startcheck) System.out.println(s.length);
        else  System.out.println(s.length-1);


    }


}