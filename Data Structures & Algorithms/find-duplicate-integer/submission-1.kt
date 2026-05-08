class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for (value in nums) {
            val index = abs(value) - 1
            if (nums[index] < 0) {
                return abs(value)
            } else {
                nums[index] = -nums[index]
            }
        }

        return -1
    }
}
