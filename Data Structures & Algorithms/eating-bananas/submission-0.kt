class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var k = Integer.MAX_VALUE

        var maxPile = Integer.MIN_VALUE
        for (pile in piles) {
            if (pile > maxPile) {
                maxPile = pile
            }
        }

        var l = 1
        var r = maxPile

        while (l <= r) {
            val m = l + (r - l) / 2

            var totalH = 0
            for (pile in piles) {
                totalH += ceil(pile.toDouble() / m).toInt()
            }

            if (totalH <= h) {
                k = min(k, m)
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return k
    }
}
