package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        return if (sadArray.size <= 2) {
            sadArray
        } else {
            val newArray = sadArray.toMutableList()
            var bad = newArray.find { !isElementHappy(newArray, it) }
            while (bad != null) {
                newArray.remove(bad)
                bad = newArray.find { !isElementHappy(newArray, it) }
            }
            return newArray.toIntArray()
        }
    }

    private fun isElementHappy(list: MutableList<Int>, element: Int): Boolean {
        val index = list.indexOf(element)
        return index == 0 || index == list.lastIndex
                || element <= list[index - 1] + list[index + 1]
    }
}
