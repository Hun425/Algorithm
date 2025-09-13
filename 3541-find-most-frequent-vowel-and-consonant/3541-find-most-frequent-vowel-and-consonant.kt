class Solution {
        fun maxFreqSum(s: String): Int {
            val freqMap = mutableMapOf<Char,Int>()

            for(char in s){
                freqMap[char] = freqMap.getOrDefault(char, 0) +1
            }

            val vowels = setOf('a','e','i','o','u')
            var maxVowelFreq = 0
            var maxConsonantFreq = 0

            for ((char,freq) in freqMap){
                if(char in vowels){
                    maxVowelFreq = maxOf(maxVowelFreq,freq)
                }else{
                    maxConsonantFreq = maxOf(maxConsonantFreq,freq)
                }
            }

            return maxVowelFreq + maxConsonantFreq
        }
    }