package sorting

/**
 * bubble sort
 *
 * worst time: n²
 * the best time: n²
 * average time: n²
 *
 * amount of memory: 1
 */

fun <T : Comparable<T>> Array<T>.bubbleSort() {
    val array = this
    for (i in 0 until size - 1) {
        for (j in 0 until size - 1 - i) {
            if (array[j] > array[j + 1]) {
                array[j] = array[j + 1].apply {
                    array[j + 1] = array[j]
                }
            }
        }
    }
}

fun <T : Comparable<T>> MutableList<T>.bubbleSort() {
    val list = this
    for (i in 0 until size - 1) {
        for (j in 0 until size - 1 - i) {
            if (list[j] > list[j + 1]) {
                list[j] = list[j + 1].apply {
                    list[j + 1] = list[j]
                }
            }
        }
    }
}
