class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        var zeros = 0
        var multiple = 1

        for (num in nums) {
            if (num == 0) {
                zeros++
            } else {
                multiple *= num 
            }
        }

        if (zeros > 1) {
            return result
        }

        for ((index, num) in nums.withIndex()) {
            if (zeros > 0) { 
                if (num != 0) {
                    result[index] = 0
                } else {
                    result[index] = multiple
                }
            } else {
                result[index] = multiple/num
            }
        }

        return result
    }
}
