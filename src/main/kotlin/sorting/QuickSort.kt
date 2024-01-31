package sorting

import kotlin.random.Random

/**
 *
 * QuickSort is a sorting algorithm based on the Divide and Conquer algorithm
 *
 * that picks an element as a pivot and partitions the given array around the picked pivot
 *
 * by placing the pivot in its correct position in the sorted array.
 *
 *
 * worst time: n²
 * best time: n * log(n)
 * average time: n * log(n)
 *
 * amount of memory: n
 *
 */

class QuickSort {

    fun <T : Comparable<T>> sort(array: Array<T>, start: Int = 0, end: Int = array.size - 1) {
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
                val tmp = array[i]
                array[i] = array[j]
                array[j] = tmp
                i++
                j--
            }
        }

        if (i < end) sort(array, i, end)
        if (0 < j) sort(array, start, j)
    }

}