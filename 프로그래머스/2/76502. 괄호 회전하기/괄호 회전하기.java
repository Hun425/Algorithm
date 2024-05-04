import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i =0; i<s.length();i++){
            String first = s.substring(0,1);
            String last = s.substring(1);
            s = last+first;
        
            if(check(s))answer++;
        }
        return answer;
    }

    boolean check(String s){
                Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.substring(i,i+1));
        }
    
        String now = "";
           for (int i = 0; i < s.length(); i++) {
            now = queue.poll();
            if(now.equals("(")){
                stack.add(now);
            } else if (now.equals("{")) {
                stack.add(now);
            } else if (now.equals("[")) {
                stack.add(now);                
            } else if (now.equals(")")) {
                if(stack.isEmpty())return false;
                String next = stack.pop();
                if(!next.equals("(")) return false;
            } else if (now.equals("}")) {
                if(stack.isEmpty())return false;
                String next = stack.pop();
                if(!next.equals("{")) return false;
            } else if (now.equals("]")) {
                if(stack.isEmpty())return false;
                String next = stack.pop();
                if(!next.equals("[")) return false;
            }

        }
        if(stack.size()>0)return false;
        return true;
    }

}