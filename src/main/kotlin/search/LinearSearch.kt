package search

/**
 * простой алгоритм линейного поиска
 *
 * худший случаай: n
 * количество памяти: 1
 */
class LinearSearch<T : Comparable<T>> : Search<T> {

    /**
     * возвращает true, если элемент был найден в массиве
     *
     * @array - отсортированный массив
     * @element - искомый элемент
     */
    override fun exists(array: Array<T>, element: T) : Boolean {
        return search(array, element) != -1
    }

    /**
     * возвращает индекс искомого элемента, в противном случае -1
     *
     * @array - отсортированный массив
     * @element - искомый элемент
     */
    override fun search(array: Array<T>, element: T) : Int {
        for (i in array.indices) {
            if (element == array[i]) {
                return i
            }
        }
        return -1
    }

}