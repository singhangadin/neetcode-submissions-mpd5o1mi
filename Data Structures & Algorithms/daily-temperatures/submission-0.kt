class Solution {

    data class Value(val index: Int, val value: Int)

    val stack = Stack<Value>()

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 }

        for ((index, temperature) in temperatures.withIndex()) {
            while (stack.size > 0 && temperature > stack.peek().value) {
                val top = stack.pop()
                val difference = index - top.index

                result[top.index] = difference
            }

            stack.push(Value(index, temperature))
        }

        return result
    }
}
