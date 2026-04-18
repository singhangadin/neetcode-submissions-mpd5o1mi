class Solution {

    data class Value (val index: Int, val value: Int)

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxHeap = PriorityQueue<Value>(compareByDescending { it.value })
        val result = IntArray(nums.size - k + 1)

        var l = 0
        var r = 0

        for (i in nums.indices) {
            maxHeap.add(Value(i, nums[i]))

            if (i >= k - 1) {
                val windowStart = i - k + 1

                while (maxHeap.peek().index < windowStart) {
                    maxHeap.poll()
                }

                result[windowStart] = maxHeap.peek().value
            }
        }

        return result
    }
}
