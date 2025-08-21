class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        

        val m = matrix.size
        val n = matrix[0].size

        val dp = Array(m){IntArray(n)}

    

        for(i in 0 until m){
            for(j in 0 until n){
                if(matrix[i][j]==1){
                    dp[i][j] = 1
                }
            }
        }

        for(i in 0 until m){
            for(j in 0 until n){

                if(matrix[i][j]==0)continue

                if(i==0 || j==0){
                    dp[i][j] = 1
                    continue
                } 

                dp[i][j] = minOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
            }
        }

        var ans = 0;
        for(i in 0 until m){
            for(j in 0 until n){
                    ans+=dp[i][j]
             
            }
        }


        return ans 
    }
}