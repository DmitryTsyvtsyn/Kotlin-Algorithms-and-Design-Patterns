package sorting

/**
 * improved bubble sort
 *
 * worst time: n²
 * the best time: n
 * average time: n²
 *
 * amount of memory: 1
 */


fun <T : Comparable<T>> Array<T>.bubbleSortImproved() {
    val array = this
    var isSorted = true
    for (i in 0 until size - 1) {
        for (j in 0 until size - 1 - i) {
            if (array[j] > array[j + 1]) {
                isSorted = false
                array[j] = array[j + 1].apply {
                    array[j + 1] = array[j]
                }
            }
        }
        if (isSorted) break
    }
}

fun <T : Comparable<T>> MutableList<T>.bubbleSortImproved() {
    val list = this
    var isSorted = true
    for (i in 0 until size - 1) {
        for (j in 0 until size - 1 - i) {
            if (list[j] > list[j + 1]) {
                isSorted = false
                list[j] = list[j + 1].apply {
                    list[j + 1] = list[j]
                }
            }
        }
        if (isSorted) break
    }
}
