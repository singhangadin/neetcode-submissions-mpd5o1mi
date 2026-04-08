class Solution {

    val sLookUp = HashMap<Char, Int>()
    val tLookUp = HashMap<Char, Int>()

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        for (ch in s) {
            sLookUp[ch] = sLookUp.getOrDefault(ch, 0) + 1
        }

        for (ch in t) {
            tLookUp[ch] = tLookUp.getOrDefault(ch, 0) + 1
        }

        for (ch in sLookUp.keys) {
            if (sLookUp[ch] != tLookUp[ch]) {
                return false
            }
        }

        return true
    }
}
