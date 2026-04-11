class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { hashSetOf<Char>() }
        val columns = Array(9) { hashSetOf<Char>() }
        val squares = Array(9) { hashSetOf<Char>() }

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val squareIndex = ((r/3) * 3) + (c/3)
                val ch = board[r][c]

                if (ch == '.') {
                    continue
                }

                if (ch in rows[r] || ch in columns[c] || ch in squares[squareIndex]) {
                    return false
                }

                rows[r] += ch
                columns[c] += ch
                squares[squareIndex] += ch
            }
        }

        return true
    }
}
