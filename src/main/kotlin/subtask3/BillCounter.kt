package subtask3

class BillCounter {
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val correctAmount = (bill.sum() - bill[k]) / 2
        return if (correctAmount == b) {
            "Bon Appetit"
        } else {
            (b - correctAmount).toString()
        }
    }
}
