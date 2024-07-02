class Solution {
    static int ans;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ans = 0;
        
        DFS(numbers,target,0,0);
        
        return ans;
    }
    static void DFS(int[]numbers,int target,int level,int now){
        
        if(level==numbers.length){
            if(now==target){
                ans++;
            }
            return;
        }
        
        DFS(numbers,target,level+1,now+numbers[level]);
        DFS(numbers,target,level+1,now-numbers[level]);
        
    }
    
    
}