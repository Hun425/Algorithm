import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {

        boolean check = true;
            Arrays.sort(phone_book);
            for(int i =0; i<phone_book.length-1; i++ ){
          
                String first = phone_book[i];
                String second = phone_book[i+1];

                if(first.length()>second.length()){
                    continue;
                }

                    boolean in = true;
                    for (int k = 0; k < first.length(); k++) {
                        if(first.charAt(k)!=second.charAt(k)){
                            in = false;
                            break;
                        }
                    }
                   if(in)return false;

            }
        return true;
    }
}