package sorting

/**
 *
 * Radix Sort is a linear sorting algorithm that sorts elements by processing them digit by digit.
 *
 * It is an efficient sorting algorithm for integers or strings with fixed-size keys.
 *
 * worst time: <number of bits of an integer> * n
 *
 * amount of memory: 2 * n
 */

class RadixSort {

    fun sort(array: Array<Int>) {
        val arraySize = array.size
        val arrayOfZeroBits = Array(arraySize) { 0 }
        val arrayOfOneBits = Array(arraySize) { 0 }

        val size = Int.SIZE_BITS

        for (radix in 0 until size) {
            var size1 = 0
            var size2 = 0
            for (index in array.indices) {
                if (array[index].and(1 shl radix) == 0) {
                    arrayOfZeroBits[size1++] = array[index]
                } else {
                    arrayOfOneBits[size2++] = array[index]
                }
            }

            for (index in 0 until size1) {
                array[index] = arrayOfZeroBits[index]
            }

            for (index in 0 until size2) {
                array[size1 + index] = arrayOfOneBits[index]
            }
        }
    }

}