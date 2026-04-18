class Solution {
    fun minWindow(s: String, t: String): String {
        var result = ""

        if (s.length < t.length) {
            return result
        }

        val tMap = hashMapOf<Char, Int>()
        val sMap = hashMapOf<Char, Int>()

        for (index in t.indices) {
            tMap[t[index]] = tMap.getOrDefault(t[index], 0) + 1
            sMap[s[index]] = sMap.getOrDefault(s[index], 0) + 1
        }

        val lookUpSet = tMap.keys

        var l = 0
        var r = t.length - 1

        while (r < s.length) {
            if (!doesAContainB(sMap, tMap)) {
                // Increase r as long as we don't get a match
                r++

                if (r < s.length && lookUpSet.contains(s[r])) {
                    sMap[s[r]] = sMap.getOrDefault(s[r], 0) + 1
                }
            } else {
                // We have the substring in the map, now reduce the 
                // size of the substring to its minimum.
                while (doesAContainB(sMap, tMap)) {
                    val subStringLength = r - l + 1
                    if (result == "" || result.length > subStringLength) {
                        result = s.substring(l, r + 1)
                    }
                    if (sMap[s[l]] == 1) {
                        sMap.remove(s[l])
                    } else if (lookUpSet.contains(s[l])) {
                        sMap[s[l]] = sMap.getOrDefault(s[l], 0) - 1
                    }
                    l++
                }
            }
        }

        return result
    }

    fun doesAContainB(mapS: Map<Char, Int>, mapT: Map<Char, Int>): Boolean {
        for (key in mapT.keys) {
            if (!mapS.contains(key)) {
                return false
            }

            if (mapT[key]!! > mapS[key]!!) {
                return false
            }
        }

        return true
    }
}
