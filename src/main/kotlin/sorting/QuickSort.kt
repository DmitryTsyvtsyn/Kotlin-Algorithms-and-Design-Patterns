package sorting

import kotlin.random.Random

/**
 * quicksort algorithm
 *
 * worst time: n²
 * the best time: n * log(n)
 * average time: n * log(n)
 *
 * amount of memory: n
 */
class QuickSort : SortAlgo<Int>() {

    /**
     * sorts the array specified in the parameter
     *
     * @array - array
     */
    override fun sortAlgo(array: Array<Int>) {
        sort(array, 0)
    }

    private fun sort(array: Array<Int>, start: Int = 0, end: Int = array.size - 1) {
        if (array.isEmpty()) return
        if (start >= end) return

        val pivotIndex = Random.nextInt(start, end + 1)
        val pivot = array[pivotIndex]

        var i = start
        var j = end

        while (i <= j) {
            while (array[i] < pivot) {
                i++
            }
            while (array[j] > pivot) {
                j--
            }
            if (i <= j) {
                array[i] = array[j].apply {
                    array[j] = array[i]
                }
                i++
                j--
            }
        }

        if (i < end) sort(array, i, end)
        if (0 < j) sort(array, start, j)
    }

}