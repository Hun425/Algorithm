import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
 HashMap<Integer,Integer> map = new HashMap<>();

        Queue<dict> que = new ArrayDeque<>();
        Queue<dict> que2 = new ArrayDeque<>();


        int idx = 0;

        for (int i = 0; i < priorities.length; i++) {
            que.add(new dict(priorities[i],idx++));
        }

        int cnt=1;
        while(!que.isEmpty()) {
            dict now = que.poll();

            boolean check = false;

            while(!que.isEmpty()){
                dict next = que.poll();
                que2.add(next);
                if(now.priority< next.priority)check=true;
            }

            while(!que2.isEmpty()){
                dict next = que2.poll();
                que.add(next);
            }

            if (check) {
                check=false;
                que.add(now);
            } else {
                if (now.idx == location) break;

                cnt++;
            }
        }

        return cnt;
    }
    class dict {
        int priority;
        int idx;

        public dict(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}