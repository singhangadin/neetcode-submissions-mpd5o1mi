class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size - 1) {
            val a = nums[i]
            if (a > 0) {
                break
            }

            if (i > 0 && a == nums[i - 1]) {
                continue
            }

            var l = i + 1
            var r = nums.size - 1
            
            while (l < r) {

                val sum = a + nums[l] + nums[r]
                if (sum > 0) {
                    r--
                } else if (sum < 0) {
                    l++
                } else {
                    result.add(mutableListOf(a, nums[l], nums[r]))
                    l++
                    r--
                    while (l < r && nums[l] == nums[l - 1]) l++
                    while (l < r && nums[r] == nums[r + 1]) r--
                }
            }
        }

        return result
    }
}