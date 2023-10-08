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

fun <T : Comparable<T>> Array<T>.quickSort(start: Int = 0, end: Int = size - 1) {
    val array = this

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

    if (i < end) quickSort(i, end)
    if (0 < j) quickSort(start, j)
}

fun <T : Comparable<T>> MutableList<T>.quickSort(start: Int = 0, end: Int = size - 1) {
    val list = this

    if (list.isEmpty()) return
    if (start >= end) return

    val pivotIndex = Random.nextInt(start, end + 1)
    val pivot = list[pivotIndex]

    var i = start
    var j = end

    while (i <= j) {
        while (list[i] < pivot) {
            i++
        }
        while (list[j] > pivot) {
            j--
        }
        if (i <= j) {
            list[i] = list[j].apply {
                list[j] = list[i]
            }
            i++
            j--
        }
    }

    if (i < end) quickSort(i, end)
    if (0 < j) quickSort(start, j)
}