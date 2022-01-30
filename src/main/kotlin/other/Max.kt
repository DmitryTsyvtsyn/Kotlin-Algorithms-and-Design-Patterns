package other

import java.lang.IllegalArgumentException

/**
 * Algorithm for finding the maximum value from a list
 *
 */

class Max<T : Comparable<T>> {

    /**
     * returns the maximum element from the list
     * @items - list of elements
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