package sorting

/**
 * улучшенный вариант пузырьковой сортировки: если массив уже отсортирован, то после
 * первого прохода по массиву, мы завершаем выполнение алгоритма за время n
 * худший случай: n²
 * лучший случай: n
 * средний случай: n²
 */
class BubbleSortImproved<T : Comparable<T>> : SortAlgo<T>() {

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