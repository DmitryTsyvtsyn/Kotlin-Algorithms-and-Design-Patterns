package sorting

class InsertionSort<T : Comparable<T>> : SortAlgo<T>() {
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