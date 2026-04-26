class Solution {
    fun findMin(nums: IntArray): Int { 
        if (nums[0] <= nums[nums.size - 1]) return nums[0]

        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val m = (l + r) ushr 1
            
            if (nums[m] < nums[r]) {
                r = m
            } else {
                l = m + 1
            }
        }

        return nums[l]
    }
}
