package subtask4

class StringParser {

    private val brackets = mapOf("[" to "]", "(" to ")", "<" to ">")

    private fun String.startIndex(endIndex: Int) = this.findAnyOf(brackets.keys, endIndex)?.first ?: -1

    private fun String.nextStartIndex(startIndex: Int) = this.indexOf(this[startIndex], startIndex + 1)

    private fun String.endIndex(startIndex: Int): Int {
        return if (startIndex == -1) {
            -1
        } else {
            val bracket = brackets[this[startIndex].toString()] ?: ""
            this.indexOf(bracket, startIndex)
        }
    }

    private fun String.nextEndIndex(startIndex: Int, endIndex: Int): Int {
        return if (startIndex == -1) {
            -1
        } else {
            val bracket = brackets[this[startIndex].toString()] ?: ""
            this.indexOf(bracket, endIndex + 1)
        }
    }

    fun getResult(inputString: String): Array<String> {
        val output = ArrayList<String>()

        var startIndex = inputString.startIndex(0)
        var endIndex = inputString.endIndex(startIndex)

        while (startIndex != -1) {
            val nextStartIndex = inputString.nextStartIndex(startIndex)
            if (nextStartIndex != -1 && nextStartIndex < endIndex) {
                val nextEndIndex = inputString.nextEndIndex(startIndex, endIndex)
                output.add(inputString.substring(startIndex + 1, nextEndIndex))
                output.add(inputString.substring(nextStartIndex + 1, endIndex))
            } else {
                output.add(inputString.substring(startIndex + 1, endIndex))
            }
            startIndex = inputString.startIndex(startIndex + 1)
            endIndex = inputString.endIndex(startIndex)
        }
        return output.toTypedArray()
    }
}
