package subtask5

class HighestPalindrome {
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val minChanges = minChanges(digitString)
        var overChanges = k - minChanges
        val digitList = digitString.toMutableList()
        when {
            minChanges > k -> {
                return "-1"
            }
            else -> {
                for (i in 0 until n / 2) {
                    val first = digitList[i]
                    val last = digitList[n - i - 1]

                    if (overChanges == 0 || first == '9' || last == '9') {
                        if (first > last) digitList[n - i - 1] = first else digitList[i] = last
                    } else {
                        digitList[i] = '9'
                        digitList[n - i - 1] = '9'
                        overChanges--
                    }

                }
                return digitList.joinToString(separator = "")
            }
        }
    }


    private fun minChanges(s: String) : Int {
        var count = 0
        for (n in 0 until (s.length / 2)) {
            if (s[n] != s[s.length - n - 1]) {
                count += 1
            }
        }
        return count
    }
}
