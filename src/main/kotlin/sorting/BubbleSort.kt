package sorting

/**
 * сортировка пузырьком
 *
 * худший случай: n²
 * лучший случай: n²
 * средний случай: n²
 *
 * объем памяти: 1
 */
class BubbleSort<T : Comparable<T>> : SortAlgo<T>() {

    /**
     * сортирует указанный в параметре массив
     *
     * @array - массив
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