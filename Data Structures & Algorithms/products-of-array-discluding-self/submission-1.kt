class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }

        var prefix = 1
        for (index in 0 until nums.size) {
            result[index] = prefix
            prefix *= nums[index]
        } 
        
        var postfix = 1
        for (index in nums.size - 1 downTo 0) {
            result[index] *= postfix
            postfix *= nums[index]
        }

        return result
    }
}
