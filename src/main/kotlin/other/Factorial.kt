package other

/**
 * Algorithm for finding the factorial of a positive number n
 *
 */

class Factorial {

    /**
     * returns the factorial of a number by an iterative method
     *
     * worst time: O(n)
     * amount of memory: O(1)
     *
     * @number - positive number
     */
    fun compute(number: Int) : Int {
        var result = 1
        for (i in 1..number) {
           result *= i
        }
        return result
    }

    /**
     * returns the factorial of a number recursively
     *
     * worst time: O(n)
     * amount of memory: O(n) - stack for recursion
     *
     * @number - positive number
     */
    fun computeRecursive(number: Int) : Int {
        return if (number <= 1) {
            1
        } else {
            number * computeRecursive(number - 1)
        }
    }

}