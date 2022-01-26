package ru.sorting

/**
 * улучшенный вариант пузырьковой сортировки
 *
 * худший случай: n²
 * лучший случай: n
 * средний случай: n²
 *
 * объем памяти: 1
 */
class BubbleSortImproved<T : Comparable<T>> : SortAlgo<T>() {

    /**
     * сортирует указанный в параметре массив
     *
     * @array - массив
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