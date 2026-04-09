class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagramsMap = hashMapOf<String, MutableList<String>>()

        for (str in strs) {
            val intArr = IntArray(26)
            for (ch in str.toCharArray()) {
                intArr[ch - 'a']++
            }

            val key = intArr.joinToString(",")
            anagramsMap.getOrPut(key) { mutableListOf<String>() }.add(str)
        }

        return anagramsMap.values.toList()
    }
}
