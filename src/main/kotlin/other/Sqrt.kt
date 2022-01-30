package other

/**
 * Algorithm for finding the square root of a number
 *
 * Wikipedia: https://shorturl.at/pvAQ7
 */

class Sqrt {

    /**
     * calculates the root of a number
     *
     * @number - number
     * @return returns the root of a number
     */
    fun compute(number: Double) : Double {
        var value = number / 2
        for (i in 1..100) {
            value = (value + number / value) / 2
        }
        return value
    }

}