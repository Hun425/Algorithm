import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 과일 개수 카운트 해시맵 생성
        HashMap<Integer, Integer> map = new HashMap<>();

        // 과일 카운트
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }

        // 과일 카운트 값만 사용한 배열 생성

        ArrayList<Integer> arr = new ArrayList<>(map.values());

        // 큰 값부터 세기 위해서 내림차순 정렬
        Collections.sort(arr, Collections.reverseOrder());



        int s = 0; //과일 판매 합계
        int cnt = 0; //과일 종류 합계
        for (Integer i : arr) {
            if(s+i>=k){
                cnt++;
                break;
            }
            else{
                s+=i;
                cnt++;
            }
        }






        return cnt;

    }
}