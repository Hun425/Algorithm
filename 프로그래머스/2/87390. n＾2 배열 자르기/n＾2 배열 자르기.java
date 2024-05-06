class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
        for(int i =0; i<right-left+1;i++){
            long now = left+i;
            int col =(int) (now/n);
            int row =(int) (now%n);
            answer[i]=Math.max(col+1,row+1);
        }
        
        return answer;
    }
}