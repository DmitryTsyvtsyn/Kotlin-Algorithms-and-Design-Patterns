package search

/**
 * Алгоритм бинарного поиска , реализованный рекурсивным способом
 *
 * худший случай: log(n)
 * объем памяти: log(n) - стэк рекурсии
 */

class BinarySearchRecursive<T : Comparable<T>> : Search<T>  {

    /**
     * проверяет присутствие элемента в массиве
     * возвращает индекс искомого элемента, в противном случае -1
     *
     * @array - отсортированный массив
     * @element - искомый элемент
     */
    override fun search(array: Array<T>, element: T): Int {
        return searchRecursive(array, 0, array.size - 1, element)
    }

    /**
     * проверяет присутствие элемента в массиве
     * возвращает true или false
     *
     * @array - отсортированный массив
     * @element - искомый элемент
     */
    override fun exists(array: Array<T>, element: T): Boolean {
        return searchRecursive(array, 0, array.size - 1, element) != -1
    }

    /**
     * возвращает индекс искомого элемента, в противном случае -1
     *
     * @array - отсортированный массив
     * @left - левая граница
     * @right - правая граница
     * @element - искомый элемент
     */
    private tailrec fun searchRecursive(array: Array<T>, left: Int, right: Int, element: T) : Int {
        if (left <= right) {
            val middle = left + (right - left) / 2
            if (array[middle] == element) {
                return middle
            }
            return if (array[middle] > element) {
                searchRecursive(array, left, middle - 1, element)
            } else {
                searchRecursive(array, middle + 1, right, element)
            }
        }
        return -1
    }


}