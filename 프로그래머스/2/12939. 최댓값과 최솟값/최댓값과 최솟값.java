import java.util.*;
import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringTokenizer st2 = new StringTokenizer(s);
        StringTokenizer st3 = new StringTokenizer(s);
        int start =0;
        int cnt=0;
        int min= Integer.parseInt(String.valueOf(st.nextToken()));
        int max= Integer.parseInt(String.valueOf(st.nextToken()));

        while (st2.hasMoreTokens()) {
            min = Math.min(min,Integer.parseInt(String.valueOf(st2.nextToken())));
            max = Math.max(max,Integer.parseInt(String.valueOf(st3.nextToken())));
        }



        String answer = String.valueOf(min+" "+max);

        return answer;
    }
}