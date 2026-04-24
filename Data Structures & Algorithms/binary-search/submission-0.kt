class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(0, nums.size - 1, nums, target)
    }

    fun binarySearch(start: Int, end: Int, nums: IntArray, target: Int): Int {
        if (end < start) {
            return -1
        }
        
        val middle = start + ((end - start) / 2)

        return when {
            nums[middle] == target -> middle
            nums[middle] > target -> binarySearch(start, middle - 1, nums, target)
            nums[middle] < target -> binarySearch(middle + 1, end, nums, target)
            else -> -1
        }
    }
}
