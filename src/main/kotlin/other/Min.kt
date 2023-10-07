package other

import java.lang.IllegalArgumentException

/**
 *
 * Algorithm for finding the minimum value from a list
 *
 */

class Min<T : Comparable<T>> {

    /**
     * returns the minimum element from the list
     */
    fun compute(items: List<T>) : T {
        if (items.isEmpty()) {
            throw IllegalArgumentException("items is empty!")
        }
        var min = items[0]
        for (i in 1 until items.size) {
            if (min > items[i]) {
                min = items[i]
            }
        }
        return min
    }

    /**
     * returns the minimum element from the list recursively
     */
    fun computeRecursive(items: List<T>) : T {
        if (items.size == 1) {
            return items.first()
        }
        val first = items.first()
        val others = items.subList(1, items.size)

        val min = computeRecursive(others)

        return if (first < min) first else min
    }

}