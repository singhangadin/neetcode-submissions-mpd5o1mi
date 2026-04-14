class Solution {
    fun maxProfit(prices: IntArray): Int {

        if (prices.size < 1) {
            return 0
        }

        var maxProfit = 0
        var l = 0
        var r = 1

        while (r < prices.size) {
            maxProfit = max(maxProfit, prices[r] - prices[l])
            if (prices[l] > prices[r]) {
                l = r
            }
            r++
        }

        return max(maxProfit, 0)
    }
}
