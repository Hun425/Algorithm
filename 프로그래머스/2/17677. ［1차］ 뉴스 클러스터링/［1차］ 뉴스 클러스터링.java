import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
       str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String>  str1_result = new LinkedList<>();
        List<String> str2_result = new LinkedList<>() ;

        int cnt = 0;

        List<String> check = new ArrayList<>();
        boolean jump = false;
        for (int i = 0; i < str1.length()-1; i++) {
            String now = str1.substring(i, i+2);
            for (int j = 0; j < now.length(); j++) {
                if('A'<=now.charAt(j) && now.charAt(j)<='Z' )continue;
                else jump = true;
            }
            if (jump){
                jump=false;
                continue;
            }
            str1_result.add(now);
        }
        jump=false;
        for (int i = 0; i < str2.length()-1; i++) {
            String now = str2.substring(i, i+2);
            for (int j = 0; j < now.length(); j++) {
                if('A'<=now.charAt(j) && now.charAt(j)<='Z' )continue;
                else{
                    jump = true;
                }
            }
            if (jump){
                jump=false;
                continue;
            }
            str2_result.add(now);
        }


        int total =str1_result.size()+str2_result.size();
        if(str1_result.size()<str2_result.size()){
            List<String> temp = new ArrayList<>(str1_result);
            str1_result = str2_result;
            str2_result = temp;
        }

        for (int i = 0; i < str1_result.size(); i++) {
            if(check.contains(str1_result.get(i)))continue;
            for (int j = 0; j < str2_result.size(); j++) {
                if(check.contains(str1_result.get(i)))continue;
                if(str1_result.get(i).equals(str2_result.get(j))){

                    int cnt1 =0;
                    int cnt2 =0;
                    for (int k = 0; k < str1_result.size(); k++) {
                        if(str1_result.get(k).equals(str2_result.get(j))){
                            cnt1++;
                        }
                    }
                    for (int k = 0; k < str2_result.size(); k++) {
                        if(str2_result.get(k).equals(str2_result.get(j))){
                            cnt2++;
                        }
                    }
                    cnt+=Math.min(cnt1,cnt2);
                    if(!check.contains(str1_result.get(i)))check.add(str1_result.get(i));
                }
            }
        }
        total-=cnt;
        double answer = (double)cnt/total;
//        double answer = (double) 4/6;
        int now = (int) Math.floor(answer*65536);
        if(str1.equals(str2))now=65536;
        return now;
    }
}