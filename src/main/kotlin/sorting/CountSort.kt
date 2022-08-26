package sorting

/**
 * count sort
 *
 * worst time: n
 * the best time: n
 * average time: n
 *
 * amount of memory: equals to the size of the range of numbers plus 1 (for example: 1001 for numbers from 0 to 1000)
 *
 * The use of counting sort is useful only when the sorted numbers have (or can be mapped to) a range of possible
 * values that is small enough compared to the sorted set, for example, a million natural numbers less than 1000
 *
 */

fun Array<Int>.countSort(start: Int, end: Int) { // sorts numbers in the range from start to end
    val countedNumbers = Array(end + 1) { 0 }

    var index = 0
    while (index < size) {
        countedNumbers[this[index]]++
        index++
    }

    index = 0
    var currentNumber = start
    while (currentNumber < countedNumbers.size) {
        var frequency = countedNumbers[currentNumber]
        while (frequency > 0) {
            this[index++] = currentNumber
            frequency--
        }
        currentNumber++
    }
}