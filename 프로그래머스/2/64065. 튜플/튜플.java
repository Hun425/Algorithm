import java.util.*;
class Solution {
    public int[] solution(String s) {
       String result = s.substring(1,s.length()-2);

        String [] ans = result.split("}");

        Arrays.sort(ans,(o1, o2) -> o1.length()-o2.length());


        //"{{1,2,3},{2,1},{1,2,4,3},{2}}"
        //"{{20,111},{111}}"
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < ans.length; i++) {
            String v = ans[i];

            for (int j = 0; j <v.length() ; j++) {


                if('0'<=v.charAt(j) && v.charAt(j)<='9') {
                    int start = j;
                    while(j<v.length()){
                        j++;
                        if(j>=v.length()) break;
                        if('0'<=v.charAt(j) && v.charAt(j)<='9')continue;
                        else break;
                    }
                    String nw = v.substring(start,j);
                    int now =Integer.parseInt(nw);
                    if (!que.contains(now)) que.add(now);
                }
            }
        }
        int[] answer = new int[que.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = que.poll();
    
        }

        return answer;
    }
}