class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)

        var start = 0
        var end = numbers.size - 1
        var sum = numbers[start] + numbers[end]

        while (sum != target) {
            if (sum > target) {
                end--
            } else {
                start++
            }

            sum = numbers[start] + numbers[end]
        }
        result[0] = start + 1
        result[1] = end + 1
        return result
    }
}
