class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.filter { it.isLetterOrDigit() }.lowercase()
        val strLength = str.length - 1

        for (i in 0 until (str.length) / 2) {
            if (str[i] != str[strLength - i]) {
                return false
            }
        }

        return true
    }
}
