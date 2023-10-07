package other

/**
 *
 * Knut Morris Pratt's Algorithm for finding a substring in a string
 *
 */

class KnuthMorrisPratt {

    /**
     * returns an array of prefix functions for a string
     */
    private fun prefixFunction(str: String) : Array<Int> {
        val pi = Array(str.length) { 0 }
        for (index in 1 until str.length) {
            var k = pi[index - 1]
            while (k > 0 && str[index] != str[k]) {
                k = pi[k - 1]
            }
            if (str[index] == str[k]) {
                k++
            }
            pi[index] = k
        }
        return pi
    }

    /**
     * returns true if the substring is in the string
     */
    fun contains(sub: String, str: String) : Boolean {
        val summary = "$sub#$str"
        val pi = prefixFunction(summary)
        return pi.any { value -> value == sub.length }
    }

    /**
     * returns the number of occurrences of a substring in a string
     */
    fun count(sub: String, str: String) : Int {
        val summary = "$sub#$str"
        return prefixFunction(summary).count { value -> value == sub.length }
    }
}