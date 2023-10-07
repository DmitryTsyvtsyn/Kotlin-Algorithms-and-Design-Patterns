package other

/**
 *
 * Algorithm for comparing two strings with a hash
 *
 */

class StringEqualsHash {

    /**
     *
     * computes the hash of a string according to the formula:
     *
     * hash(abc) = a.code * primeCoefficient⁰ + b.code * primeCoefficient¹ + c.code * primeCoefficient²
     *
     * @return returns the hash of the string
     *
     */
    private fun String.hash() : Int {
        var result = 0
        var factor = 1
        forEach { symbol ->
            result += symbol.code * factor
            factor *= primeCoefficient
        }
        return result.mod(Int.MAX_VALUE)
    }

    fun equals(source: String, pattern: String) : Boolean =
        if (source.length != pattern.length) false else source.hash() == pattern.hash()

    companion object {
        /**
         *
         * I chose the nearest prime number for the size of the alphabet
         *
         * my alphabet is [a-z] [A-Z] ! , .
         *
         * size of the alphabet = 26 + 26 + 3 = 55 (is not prime)
         *
         */
        private const val primeCoefficient = 53
    }
}