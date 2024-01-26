package other

/**
 *
 * Euclid's algorithm for finding the greatest common divisor
 *
 */

class EuclidAlgorithm {

    fun computeByDivisionWithRemainder(number1: Int, number2: Int) : Int {
        var copyNumber1 = number1
        var copyNumber2 = number2
        while (copyNumber1 != 0 && copyNumber2 != 0) {
            if (copyNumber1 > copyNumber2) {
                copyNumber1 %= copyNumber2
            } else {
                copyNumber2 %= copyNumber1
            }
        }
        return copyNumber1 + copyNumber2
    }

    fun computeBySubtraction(number1: Int, number2: Int): Int {
        var copyNumber1 = number1
        var copyNumber2 = number2
        while (copyNumber1 != copyNumber2) {
            if (copyNumber1 > copyNumber2) {
                copyNumber1 -= copyNumber2
            } else {
                copyNumber2 -= copyNumber1
            }
        }
        return copyNumber1
    }

}