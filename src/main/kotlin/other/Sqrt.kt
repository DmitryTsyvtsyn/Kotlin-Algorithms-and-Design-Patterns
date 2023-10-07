package other

/**
 * Algorithm for finding the square root of a number
 *
 * Wikipedia: https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Heron's_method
 */

class Sqrt {

    /**
     * calculates the root of a number and returns result
     */
    fun compute(number: Double) : Double {
        var value = number / 2
        for (i in 1..100) {
            value = (value + number / value) / 2
        }
        return value
    }

}