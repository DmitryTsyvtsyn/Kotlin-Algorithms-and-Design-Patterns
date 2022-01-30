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
class BubbleSortImproved<T : Comparable<T>> : SortAlgo<T>() {

    /**
     * sorts the array specified in the parameter
     *
     * @array - array
     */
    override fun sortAlgo(array: Array<T>) {
        var isSorted = true
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - 1 - i) {
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

}