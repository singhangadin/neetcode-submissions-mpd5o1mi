class Solution {
    val numSet = HashSet<Int>()

    fun hasDuplicate(nums: IntArray): Boolean {
        for (num in nums) {
            if (num in numSet) {
                return true
            } else {
                numSet += num
            }
        }

        return false
    }
}
