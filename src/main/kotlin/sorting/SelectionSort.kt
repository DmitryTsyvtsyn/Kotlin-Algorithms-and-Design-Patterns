package sorting

/**
 *
 * Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting
 *
 * the smallest (or largest) element from the unsorted portion of the list and
 *
 * moving it to the sorted portion of the list.
 *
 * worst time: n²
 * best time: n²
 * average time: n²
 *
 * amount of memory: 1
 *
 */

class SelectionSort {

    fun <T : Comparable<T>> sort(array: Array<T>) {
        val arraySize = array.size
        for (i in 0 until arraySize - 1) {
            var min = i
            for (j in i + 1 until arraySize) {
                if (array[min] > array[j]) {
                    min = j
                }
            }
            if (min != i) {
                val tmp = array[i]
                array[i] = array[min]
                array[min] = tmp
            }
        }
    }

}
