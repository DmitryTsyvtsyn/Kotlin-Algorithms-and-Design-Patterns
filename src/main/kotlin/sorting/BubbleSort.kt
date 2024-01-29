package sorting

/**
 *
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
 *
 * that repeatedly steps through the input list element by element, comparing the current element
 *
 * with the one after it, swapping their values if needed
 *
 */

class BubbleSort {

    /**
     * worst time: n²
     * best time: n²
     * average time: n²
     *
     * amount of memory: 1
     */
    fun <T : Comparable<T>> sort(array: Array<T>) {
        val arraySize = array.size
        for (i in 0 until arraySize - 1) {
            for (j in 0 until arraySize - 1 - i) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j + 1]
                    array[j + 1] = array[j]
                    array[j] = tmp
                }
            }
        }
    }

    /**
     * worst time: n²
     * best time: n
     * average time: n²
     *
     * amount of memory: 1
     */
    fun <T : Comparable<T>> sortImproved(array: Array<T>) {
        val arraySize = array.size
        var isSorted = true
        for (i in 0 until arraySize - 1) {
            for (j in 0 until arraySize - 1 - i) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j + 1]
                    array[j + 1] = array[j]
                    array[j] = tmp

                    isSorted = false
                }
            }
            if (isSorted) break
        }
    }

}
