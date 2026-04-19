class MinStack() {
    val stack = Stack<Int>()
    val minStack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.size == 0) {
            minStack.push(`val`)
        } else {
            if (minStack.peek() <= `val`) {
                minStack.push(minStack.peek())
            } else {
                minStack.push(`val`)
            }
        }
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
