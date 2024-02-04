import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        // 두명만 채우면 되므로 투포인터
        //

        int start = 0;
        int end = people.length-1;
        while(start<=end){
            int mid = (start+end)/2;

            if(people[start]+people[end]>limit){
                end = end-1;
                answer++;
            } else if (people[start] + people[end] <= limit) {
                end--;
                start++;
                answer++;
            }
        }
        return answer;
    }
}