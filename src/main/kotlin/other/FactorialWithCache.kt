package other

/**
 *
 * Algorithm for finding the factorial of a positive number n
 *
 * optimization: caching previous factorial values
 *
 * worst time: O(n)
 * the best time: O(1)
 * amount of memory: O(n)
 *
 */

class FactorialWithCache {

    private val cache = hashMapOf<Int, Int>()

    fun compute(number: Int) : Int {
        if (number <= 1) {
            return 1
        }

        if (cache.contains(number)) {
            return cache[number]!!
        }

        var result = 1
        for (i in 2..number) {
            result *= i
            cache[i] = result
        }
        return result
    }

}