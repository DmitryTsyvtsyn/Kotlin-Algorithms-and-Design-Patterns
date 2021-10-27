package search

/**
 * алгоритм бинарного поиска
 * худший случай: lon(n)
 */
class BinarySearch<T : Comparable<T>> : Search<T> {

    /**
     * находит левую границу для текущего элемента
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
     * находит правую границу для текущего элемента
     * @array - отсортированный массив, поиск в котором осуществляется
     * @element - элемент, для которого идет поиск правой границы
     */
    fun rightBound(array: Array<T>, element: T) : Int {
        var left = -1
        var right = array.size
        while ((right - left) > 1) {
            val middle = (right - left) / 2
            if (element > array[middle]) {
                left = middle
            } else {
                right = middle
            }
        }
        return right
    }

    /**
     * возвращает true, если элемент присутствует в массиве, в противном случае false
     */
    override fun exists(array: Array<T>, element: T): Boolean {
        return search(array, element) != -1
    }

    /**
     * возвращает индекс, если элемент был найден в массив, иначе -1
     * @array - массив, в котором мы ищем элемент
     * @element - искомый элемент
     */
    override fun search(array: Array<T>, element: T) : Int {
        val leftBound = leftBound(array, element)
        val potentialIndex = leftBound + 1
        return if (potentialIndex < array.size && array[potentialIndex] == element) {
            potentialIndex
        } else {
            -1
        }
    }

}