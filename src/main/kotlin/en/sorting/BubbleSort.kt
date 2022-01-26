package en.sorting

/**
 * bubble sort
 *
 * worst time: n²
 * the best time: n²
 * average time: n²
 *
 * amount of memory: 1
 */
class BubbleSort<T : Comparable<T>> : SortAlgo<T>() {

    /**
     * sorts the array specified in the parameter
     *
     * @array - array
     */
    override fun sortAlgo(array: Array<T>) {
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - 1 - i) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1].apply {
                        array[j + 1] = array[j]
                    }
                }
            }
        }
    }

}