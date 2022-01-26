package ru.search

/**
 * название: алгоритм бинарного поиска
 *
 * описание: одной из самых важных особенностей этого алгоритма является то, что он
 * работает только для отсортированных списков и массивов
 *
 * время: log(n)
 * объем памяти: 1
 */

class BinarySearch<T : Comparable<T>> : Search<T> {

    /**
     * находит левую границу для вставки элемента в отсортированный массив
      *
     * @array - отсортированный массив, поиск в котором осуществляется
     * @element - элемент, для которого идет поиск левой границы
     */
    fun leftBound(array: Array<T>, element: T) : Int {
        var left = -1
        var right = array.size
        while ((right - left) > 1) {
            val middle = (right + left) / 2
            if (element > array[middle]) {
                left = middle
            } else {
                right = middle
            }
        }
        return left
    }

    /**
     * находит правую границу для вставки элемента в отсортированный массив
     *
     * @array - отсортированный массив, поиск в котором осуществляется
     * @element - элемент, для которого идет поиск правой границы
     */
    fun rightBound(array: Array<T>, element: T) : Int {
        var left = -1
        var right = array.size
        while ((right - left) > 1) {
            val middle = (right + left) / 2
            if (element > array[middle]) {
                left = middle
            } else {
                right = middle
            }
        }
        return right
    }

    /**
     * проверяет, если ли элемент в массиве
     *
     * @array - массив, в котором мы ищем элемент
     * @element - искомый элемент
     *
     * @return возвращает true, если элемент присутствует в массиве, в противном случае false
     */
    override fun exists(array: Array<T>, element: T): Boolean {
        return search(array, element) != -1
    }

    /**
     * осуществляет поиск элемента в массиве
     *
     * @array - массив
     * @element - искомый элемент
     *
     * @return возвращает индекс искомого элемента или -1
     */
    override fun search(array: Array<T>, element: T) : Int {
        var left = 0
        var right = array.size - 1
        while (left <= right) {
            val middle = (left + right) / 2
            if (array[middle] < element) {
                left = middle + 1
            } else if (array[middle] > element) {
                right = middle
            } else {
                return middle
            }
        }
        return -1
    }

}