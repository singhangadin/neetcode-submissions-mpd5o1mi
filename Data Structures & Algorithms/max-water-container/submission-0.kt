class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxArea = -1
        var l = 0
        var r = heights.size - 1

        while (l < r) {
            val area = min(heights[l], heights[r]) * (r - l)
            maxArea = max(maxArea, area)

            if (heights[l] > heights[r]) {
                r--
            } else if (heights[l] < heights[r]) {
                l++
            } else {
                if (heights[l] < heights[l + 1]) {
                    l++
                } else {
                    r--
                }
            }
        }

        return maxArea
    }
}
