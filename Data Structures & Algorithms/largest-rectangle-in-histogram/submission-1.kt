class Solution {

    fun largestRectangleArea(heights: IntArray): Int {
        var maxHeight = 0
        val stack = Stack<Pair<Int, Int>>()

        for ((index, height) in heights.withIndex()) {
            if (stack.size == 0) {
                stack.push(index to height)
            } else {
                val top = stack.peek()
                if (top.second <= height) {
                    stack.push(index to height)
                } else {
                    var startIndex = top.first
                    while (stack.size > 0 && stack.peek().second > height) {
                        val pop = stack.pop()
                        val area = (index - pop.first) * pop.second
                        maxHeight = max(area, maxHeight)
                        startIndex = pop.first
                    }
                    stack.push(startIndex to height)
                }
            }
        }

        while (stack.size > 0) {
            val pop = stack.pop()
            val area = pop.second * (heights.size - pop.first)
            maxHeight = max(area, maxHeight)
        }

        return maxHeight
    }
}
