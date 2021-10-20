package sorting

class SelectionSort<T : Comparable<T>> : SortAlgo<T>() {
    override fun sortAlgo(array: Array<T>) {
        for (i in 0 until array.size - 1) {
            var min = i
            for (j in i + 1 until array.size) {
                if (array[min] > array[j]) {
                    min = j
                }
            }
            if (min != i) {
                array[min] = array[i].apply {
                    array[i] = array[min]
                }
            }
        }
    }
}