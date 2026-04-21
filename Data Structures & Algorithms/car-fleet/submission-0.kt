class Solution {
    val stack = ArrayDeque<Double>()

    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pair = position.zip(speed).sortedByDescending { it.first }

        for (car in pair) {
            val currentTime = (target - car.first) / car.second.toDouble()
            if (stack.isEmpty() || stack.last() < currentTime) {
                stack.addLast(currentTime)
            }
        }

        return stack.size
    }
}
