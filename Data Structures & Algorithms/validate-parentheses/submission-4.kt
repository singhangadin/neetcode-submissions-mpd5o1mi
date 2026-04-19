class Solution {
    fun isValid(s: String): Boolean {

        val lookUpHash = hashMapOf<Char, Char>(
            ')' to '(',
            '}' to '{',
            ']' to '[',
        )
        val keys = lookUpHash.keys

        val stack = Stack<Char>()
        for (ch in s) {
            if (ch in keys) {
                if (stack.size == 0 || stack.pop() != lookUpHash[ch]) {
                    return false
                } else {
                    continue
                }
            } else {
                stack.push(ch)
            }
        }

        return stack.size == 0
    }
}
