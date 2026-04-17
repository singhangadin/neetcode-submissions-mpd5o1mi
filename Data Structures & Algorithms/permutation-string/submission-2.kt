class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }

        var l = 0
        var r = s1.length - 1

        // Preprocessing
        val s1Map = hashMapOf<Char, Int>()
        val s2Map = hashMapOf<Char, Int>()

        for (i in s1.indices) {
            s1Map[s1[i]] = s1Map.getOrDefault(s1[i], 0) + 1
            s2Map[s2[i]] = s2Map.getOrDefault(s2[i], 0) + 1
        }

        while (r < s2.length) {
            if (areMapsEqual(s1Map, s2Map)) {
                return true
            } else {
                s2Map[s2[l]] = s2Map[s2[l]]!! - 1
                if (s2Map[s2[l]] == 0) {
                    s2Map.remove(s2[l])
                }

                if (r != s2.length - 1) {
                    s2Map[s2[r + 1]] = s2Map.getOrDefault(s2[r + 1], 0) + 1
                }
                l++
                r++
            }
        }

        return false
    }

    fun areMapsEqual(map1: Map<Char, Int>, map2: Map<Char, Int>): Boolean {
        if (map1.size != map2.size) {
            return false
        } else {
            for (key in map1.keys) {
                if (!map2.contains(key)) {
                    return false
                }

                if (map1[key]!! != map2[key]!!) {
                    return false
                }
            }
        }

        return true
    }
}
