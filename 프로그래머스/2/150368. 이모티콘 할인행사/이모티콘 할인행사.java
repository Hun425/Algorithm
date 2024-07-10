import java.util.*;
class Solution {
    static int cnt, money;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0,0};
        int[]path = new int[emoticons.length];
        DFS(users,emoticons,0,path);
        
        answer[0]=cnt;
        answer[1]=money;
        return answer;
    }
    static void DFS(int[][] users, int[] emoticons,int level,int[]path) {
        if(level == emoticons.length){

            int[] ans = count(users,emoticons,path);

            if(ans[0]>cnt){
                cnt = ans[0];
                money = ans[1];
            }

            else if(ans[0]==cnt){
                if(money<ans[1]){
                    cnt = ans[0];
                    money = ans[1];
                }
            }

            return;
        }

        for (int i = 1; i < 5; i++) {
                path[level]=i;
                DFS(users,emoticons,level+1,path);

        }
    }
    static int[] count (int[][]users, int[] emoticons,int[]path) {
        int [] ans = {0,0};

        for (int i = 0; i < users.length; i++) {
            int standardMoney = users[i][1];
            int discount = users[i][0];

            int nowBuy = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if(discount>path[j]*10)continue;
                int emoticonBuy = emoticons[j]*path[j]*10/100;

                nowBuy += emoticons[j]-emoticonBuy;

            }
            if(standardMoney<=nowBuy){

                ans[0]++;// 이모티콘플러스 가입자수
            }
            else{
                ans[1]+=nowBuy;
            }
        }

        return ans;
    }
}