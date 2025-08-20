class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var totalCount: Long = 0
        var consecutiveZeros: Long = 0

        for(num in nums){
            if(num == 0){
                // 0을 만나면 연속 카운트 증가
                consecutiveZeros++
            }else{
                if(consecutiveZeros > 0){
                    totalCount += consecutiveZeros * (consecutiveZeros+1)/2
                }
                consecutiveZeros = 0
            }
        }
        if(consecutiveZeros >0){
            totalCount += consecutiveZeros * (consecutiveZeros+1)/2
        }

        return totalCount
    }
}