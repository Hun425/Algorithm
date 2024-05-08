import java.util.*;

class Solution {
    public int solution(String[][] clothes){
        HashMap<String,Integer> map = new HashMap<>();
        int answer=1;
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int[] arr = new int[clothes.length];
        int idx =0;
        for (String s : map.keySet()) {
            int v= map.get(s);
            arr[idx++]=v;
 
        }

        for (String s : map.keySet()) {
            answer *= (map.get(s)+1); // 안고르는 경우까지 추가하기
        }
        return answer-1; // 전체를 안고르는 경우 한가지 빼주기
    }
}