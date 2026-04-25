class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return binarySearch (0, (matrix.size * matrix[0].size) - 1, matrix, target)
    }

    fun binarySearch(start: Int, end: Int, matrix: Array<IntArray>, target: Int): Boolean {
        if (end < start) {
            return false
        }

        val middle = start + (end - start) / 2
        val r = floor(middle.toDouble() / matrix[0].size).toInt()
        val c = middle - (matrix[0].size * r)

        return when {
            matrix[r][c] == target -> true
            matrix[r][c] > target -> binarySearch(start, middle - 1, matrix, target)
            matrix[r][c] < target -> binarySearch(middle + 1, end, matrix, target)
            else -> false
        }
    }
}
