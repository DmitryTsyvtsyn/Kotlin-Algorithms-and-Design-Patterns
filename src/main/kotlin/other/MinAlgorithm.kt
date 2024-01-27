package other

import java.lang.IllegalArgumentException

/**
 *
 * Algorithm for finding the minimum value from a list
 *
 */

class MinAlgorithm {

    fun <T : Comparable<T>> compute(items: List<T>) : T {
        if (items.isEmpty()) {
            throw IllegalArgumentException("items list is empty!")
        }
        var min = items[0]
        for (i in 1 until items.size) {
            if (min > items[i]) {
                min = items[i]
            }
        }
        return min
    }

    fun <T : Comparable<T>> computeRecursive(items: List<T>) : T {
        if (items.isEmpty()) {
            throw IllegalArgumentException("items list is empty!")
        }
        if (items.size == 1) {
            return items.first()
        }
        val first = items.first()
        val others = items.subList(1, items.size)

        val min = computeRecursive(others)

        return if (first < min) first else min
    }

}