class Solution {
    val indexMap = HashMap<Int, Int>()

    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ((index, num) in nums.withIndex()) {
            if (target - num in indexMap) {
                return intArrayOf(indexMap[target - num]!!, index)
            } else {
                indexMap += Pair<Int, Int>(num, index)
            }
        }

        return intArrayOf(0,0)
    }
}
