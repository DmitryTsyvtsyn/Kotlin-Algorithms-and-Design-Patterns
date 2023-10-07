package other

import java.math.BigInteger

/**
 *
 * This algorithm is taken from Google Guava library
 *
 */

class FactorialAdvanced {

    private val factorials = longArrayOf(
        1L,
        1L,
        1L * 2,
        1L * 2 * 3,
        1L * 2 * 3 * 4,
        1L * 2 * 3 * 4 * 5,
        1L * 2 * 3 * 4 * 5 * 6,
        1L * 2 * 3 * 4 * 5 * 6 * 7,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19,
        1L * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19 * 20
    )

    fun compute(n: Int): BigInteger {
        if (n <= 0) {
            return BigInteger.ZERO
        }

        if (n < factorials.size) {
            return BigInteger.valueOf(factorials[n])
        }

        // Pre-allocate space for our list of intermediate BigIntegers.
        val approxSize = divide(n * log2Celling(n), Long.SIZE_BITS)
        val bigNumbers = ArrayList<BigInteger>(approxSize)

        // Start from the pre-computed maximum long factorial.
        val startingNumber = factorials.size
        var number = factorials[startingNumber - 1]
        // Strip off 2s from this value.
        var shift = number.countTrailingZeroBits()
        number = number shr shift

        // Use floor(log2(num)) + 1 to prevent overflow of multiplication.
        var numberBits = log2Floor(number) + 1
        var bits = log2Floor(startingNumber.toLong()) + 1
        // Check for the next power of two boundary, to save us a CLZ operation.
        var nextPowerOfTwo = 1 shl bits - 1

        // Iteratively multiply the longs as big as they can go.
        for (num in startingNumber..n) {
            // Check to see if the floor(log2(num)) + 1 has changed.
            if ((num and nextPowerOfTwo) != 0) {
                nextPowerOfTwo = nextPowerOfTwo shl 1
                bits++
            }
            // Get rid of the 2s in num.
            val tz = num.toLong().countTrailingZeroBits()
            val normalizedNum = (num shr tz).toLong()
            shift += tz
            // Adjust floor(log2(num)) + 1.
            val normalizedBits = bits - tz
            // If it won't fit in a long, then we store off the intermediate product.
            if (normalizedBits + numberBits >= Long.SIZE_BITS) {
                bigNumbers.add(BigInteger.valueOf(number))
                number = 1
                numberBits = 0
            }
            number *= normalizedNum
            numberBits = log2Floor(number) + 1
        }
        // Check for leftovers.
        if (number > 1) {
            bigNumbers.add(BigInteger.valueOf(number))
        }
        // Efficiently multiply all the intermediate products together.
        return listNumbers(bigNumbers).shiftLeft(shift)
    }

    /**
     * Returns the result of dividing p by q, rounding using the celling
     *
     * @throws ArithmeticException if q == 0
     */
    private fun divide(number: Int, divider: Int): Int {
        if (divider == 0) {
            throw ArithmeticException("/ by zero") // for GWT
        }
        val div = number / divider
        val rem = number - divider * div // equal to number % divider
        if (rem == 0) {
            return div
        }
        val signedNumber = 1 or (number xor divider shr Int.SIZE_BITS - 1)
        val increment = signedNumber > 0
        return if (increment) div + signedNumber else div
    }

    private fun listNumbers(numbers: List<BigInteger>, start: Int = 0, end: Int = numbers.size): BigInteger {
        return when (end - start) {
            0 -> BigInteger.ONE
            1 -> numbers[start]
            2 -> numbers[start].multiply(numbers[start + 1])
            3 -> numbers[start].multiply(numbers[start + 1]).multiply(numbers[start + 2])
            else -> {
                // Otherwise, split the list in half and recursively do this.
                val m = end + start ushr 1
                listNumbers(numbers, start, m).multiply(listNumbers(numbers, m, end))
            }
        }
    }

    /**
     * returns the base-2 logarithm of number, rounded according to the celling.
     */
    private fun log2Celling(number: Int): Int {
        return Int.SIZE_BITS - (number - 1).countLeadingZeroBits()
    }

    /**
     * returns the base-2 logarithm of number rounded according to the floor.
     */
    private fun log2Floor(number: Long): Int {
        return Long.SIZE_BITS - 1 - number.countLeadingZeroBits()
    }
}