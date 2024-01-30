package sorting

/**
 *
 * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
 *
 * The array is virtually split into a sorted and an unsorted part.
 *
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 *
 * worst time: n²
 * best time: n
 * average time: n²
 *
 * amount of time: 1
 *
 */

class InsertionSort {

    fun <T : Comparable<T>> sort(array: Array<T>) {
        val arraySize = array.size
        for (i in 1 until arraySize) {
            val current = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
        }
    }

}
