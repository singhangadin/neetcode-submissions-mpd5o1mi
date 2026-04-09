class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val frequencyMap = hashMapOf<Int, Int>()

        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val bucket = List<MutableList<Int>>(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in frequencyMap) {
            bucket[freq].add(num)
        }

        for (i in bucket.size - 1 downTo 0) {
            for (num in bucket[i]) {
                result.add(num)

                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return result.toIntArray()
    }
}
