package other

/**
 *
 * Knut Morris Pratt's Algorithm for finding a substring in a string
 *
 */

class KnuthMorrisPrattAlgorithm {
    
    // returns true if the substring is in the string
    fun contains(sub: String, str: String) : Boolean {
        val summary = "$sub$SEPARATOR$str"
        val prefixFunctionValue = prefixFunction(summary)
        return prefixFunctionValue.any { value -> value == sub.length }
    }

    // returns the number of occurrences of a substring in a string
    fun count(sub: String, str: String) : Int {
        val summary = "$sub$SEPARATOR$str"
        return prefixFunction(summary).count { value -> value == sub.length }
    }

    // returns an array of prefix functions for a string
    private fun prefixFunction(str: String) : Array<Int> {
        val prefixFunctionsValues = Array(str.length) { 0 }
        for (index in 1 until str.length) {
            var prefixFunctionValue = prefixFunctionsValues[index - 1]
            while (prefixFunctionValue > 0 && str[index] != str[prefixFunctionValue]) {
                prefixFunctionValue = prefixFunctionsValues[prefixFunctionValue - 1]
            }
            if (str[index] == str[prefixFunctionValue]) {
                prefixFunctionValue++
            }
            prefixFunctionsValues[index] = prefixFunctionValue
        }
        return prefixFunctionsValues
    }

    companion object {
        // delimiter must not occur in source strings
        private const val SEPARATOR = "#"
    }

}