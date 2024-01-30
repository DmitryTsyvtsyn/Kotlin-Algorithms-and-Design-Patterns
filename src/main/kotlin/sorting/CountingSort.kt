package sorting

/**
 *
 * Counting sort is a sorting technique based on keys between a specific range
 *
 * worst time: n
 * best time: n
 * average time: n
 *
 * amount of memory: equals to the size of the range of numbers plus 1 (for example: 1001 for numbers from 0 to 1000)
 *
 * P.S. The use of counting sort is useful only when the sorted numbers have (or can be mapped to) a range of possible
 * values that is small enough compared to the sorted set, for example, a million natural numbers less than 1000
 *
 */

class CountingSort {

    // sorts numbers in the range from start to end
    fun sort(array: Array<Int>, start: Int, end: Int) {
        val arraySize = array.size
        val countedNumbers = Array(end + 1) { 0 }

        var index = 0
        while (index < arraySize) {
            countedNumbers[array[index]]++
            index++
        }

        index = 0
        var currentNumber = start
        while (currentNumber < countedNumbers.size) {
            var frequency = countedNumbers[currentNumber]
            while (frequency > 0) {
                array[index++] = currentNumber
                frequency--
            }
            currentNumber++
        }
    }

}