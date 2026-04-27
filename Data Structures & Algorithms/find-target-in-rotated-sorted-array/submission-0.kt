class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val m = (l + r) / 2
            if (nums[m] > nums[r]) {
                l = m + 1
            } else {
                r = m
            }
        }

        val pivot = l
        l = 0
        r = nums.size - 1

        if (target >= nums[pivot] && target <= nums[r]) {
            l = pivot
        } else {
            r = pivot - 1
        }

        while (l <= r) {
            val m = (l + r) / 2
            if (nums[m] == target) {
                return m
            } else if (nums[m] < target) {
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return -1
    }
}