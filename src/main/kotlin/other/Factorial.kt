package other

/**
 *
 * Algorithm for finding the factorial of a positive number n
 *
 */

class Factorial {

    /**
     * worst time: O(n)
     * amount of memory: O(1)
     *
     * @return returns the factorial of a number by an iterative method
     */
    fun compute(number: Int) : Int {
        if (number <= 1) {
            return 1
        }

        var result = 1
        for (i in 2..number) {
           result *= i
        }
        return result
    }

    /**
     * worst time: O(n)
     * amount of memory: O(n) - stack for recursion
     *
     * @return returns factorial recursively
     */
    fun computeRecursive(number: Int) : Int {
        return if (number <= 1) {
            1
        } else {
            number * computeRecursive(number - 1)
        }
    }

    /**
     * @see <a href="https://kotlinlang.org/docs/functions.html#tail-recursive-functions">tailrec functions</a>
     */
    tailrec fun computeRecursiveWithKotlinOptimization(number: Int, result: Int = 1) : Int =
        if (number <= 1) result else computeRecursiveWithKotlinOptimization(number - 1, result * number)

}