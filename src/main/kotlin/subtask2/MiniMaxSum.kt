package subtask2

class MiniMaxSum {
    fun getResult(input: IntArray): IntArray {
        val min = input.min() ?: 0
        val max = input.max() ?: 0
        val sum = input.sum()
        return intArrayOf(sum - max, sum - min)
    }
}
