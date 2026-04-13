class Solution {
    fun trap(height: IntArray): Int {

        var l = 0
        var r = height.size - 1

        var sum = 0

        var leftMax = height[l]
        var rightMax = height[r]

        while (l < r) {
            if (leftMax < rightMax) {
                l++
                leftMax = max(leftMax, height[l])
                sum += (leftMax - height[l])
            } else {
                r--
                rightMax = max(rightMax, height[r])
                sum += (rightMax - height[r])
            }
        }

        return sum
    }
}
