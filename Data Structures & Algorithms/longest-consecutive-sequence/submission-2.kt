class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        if (nums.size == 0) {
            return 0
        }

        var longest = 1
        var streak = 1

        val lookUpSet = hashSetOf<Int>()

        for (num in nums) {
            lookUpSet += num 
        }

        for (num in lookUpSet) {
            streak = 1
            
            val less = num - 1
            if (less in lookUpSet) {
                continue
            } else {
                while (num + streak in lookUpSet) {
                    streak++
                }
            }
            longest = max(longest, streak)
        }

        return longest
    }
}
