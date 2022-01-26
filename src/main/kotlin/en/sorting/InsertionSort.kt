package en.sorting

/**
 * insertion sort algorithm
 *
 * worst time: n²
 * the best time: n²
 * average time: n
 *
 * amount of time: 1
 */
class InsertionSort<T : Comparable<T>> : SortAlgo<T>() {

    /**
     * sorts the array specified in the parameter
     *
     * @array - array
     */
    override fun sortAlgo(array: Array<T>) {
        for (i in 1 until array.size) {
            val current = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
        }
    }

}