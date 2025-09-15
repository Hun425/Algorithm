class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val checkWords = brokenLetters.toSet()

        return text.split(" ").count { word ->
            word.none {it in checkWords}
        }
    }
}