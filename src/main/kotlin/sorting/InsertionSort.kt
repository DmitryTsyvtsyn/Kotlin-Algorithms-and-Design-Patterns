package sorting

/**
 * insertion sort algorithm
 *
 * worst time: n²
 * the best time: n
 * average time: n²
 *
 * amount of time: 1
 */

fun <T : Comparable<T>> Array<T>.insertionSort() {
    val array = this
    for (i in 1 until size) {
        val current = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > current) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = current
    }
}

fun <T : Comparable<T>> MutableList<T>.insertionSort() {
    val list = this
    for (i in 1 until size) {
        val current = list[i]
        var j = i - 1
        while (j >= 0 && list[j] > current) {
            list[j + 1] = list[j]
            j--
        }
        list[j + 1] = current
    }
}
