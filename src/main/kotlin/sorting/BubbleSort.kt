package sorting

class BubbleSort<T : Comparable<T>> : SortAlgo<T> {

    override fun sort(array: Array<T>) : Array<T> {
        val newArray = array.copyOf()
        bubbleSort(newArray)
        return newArray
    }

    private fun bubbleSort(array: Array<T>) {
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