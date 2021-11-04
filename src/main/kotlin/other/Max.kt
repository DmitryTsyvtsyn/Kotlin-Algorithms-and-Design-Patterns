package other

import java.lang.IllegalArgumentException

/**
 * Алгоритм нахождения максимального значения из списка
 *
 */

class Max<T : Comparable<T>> {

    /**
     * возвращает максимальный элемент из списка
     * @items - список элементов
     */
    fun compute(items: List<T>) : T {
        if (items.isEmpty()) {
            throw IllegalArgumentException("items is empty!")
        }
        var max = items[0]
        for (i in 1 until items.size) {
            if (max < items[i]) {
                max = items[i]
            }
        }
        return max
    }

}