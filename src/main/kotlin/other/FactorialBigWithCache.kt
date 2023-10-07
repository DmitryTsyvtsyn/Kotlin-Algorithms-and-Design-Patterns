package other

import java.math.BigInteger

/**
 *
 * Algorithm for finding the factorial of a positive number n
 *
 * optimization: caching previous factorial values
 *
 * also adding large numbers
 *
 */

class FactorialBigWithCache {

    private val cache = hashMapOf<Int, BigInteger>()

    /**
     *
     * worst time: O(n)
     * the best time: O(1)
     * amount of memory: O(n)
     * problem: creating a huge number of BigInteger objects
     *
     * @return returns the factorial of a number
     */
    fun compute(number: Int) : BigInteger {
        if (number <= 1) {
            return BigInteger.ONE
        }

        if (cache.contains(number)) {
            return cache[number]!!
        }

        var result = BigInteger.ONE
        for (i in 2..number) {
            result = result.multiply(i.toBigInteger())
            cache[i] = result
        }
        return result
    }

}