package other

/**
 * Algorithm for finding the square root of a number
 *
 * Wikipedia: https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%BD%D0%B0%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D1%8F_%D0%BA%D0%BE%D1%80%D0%BD%D1%8F_n-%D0%BD%D0%BE%D0%B9_%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8
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