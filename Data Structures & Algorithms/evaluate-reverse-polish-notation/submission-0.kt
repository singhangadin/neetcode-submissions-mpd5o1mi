class Solution {
    val result = Stack<Int>()

    fun evalRPN(tokens: Array<String>): Int {
        for (token in tokens) {
            when (token) {
                "+" -> {
                    val a = result.pop()
                    val b = result.pop()

                    val add = a.toInt() + b.toInt()
                    result.push(add)
                }

                "-" -> {
                    val a = result.pop()
                    val b = result.pop()

                    val subtract = b.toInt() - a.toInt()
                    result.push(subtract)
                }

                "*" -> {
                    val a = result.pop()
                    val b = result.pop()

                    val multiply = a.toInt() * b.toInt()
                    result.push(multiply)
                }

                "/" -> {
                    val a = result.pop()
                    val b = result.pop()

                    val divide = b.toInt() / a.toInt()
                    result.push(divide)
                }

                else -> {
                    result.push(token.toInt())
                }
            }
        }
        return result.peek()
    }
}
