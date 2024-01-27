package search

/**
 *
 * Linear search algorithm
 *
 * best time: 1
 * worst time: n
 * amount of memory: 1
 *
 */

class LinearSearch {

    fun <T : Comparable<T>> search(array: Array<T>, element: T) : Int {
        var index = 0
        while (index < array.size) {
            if (element == array[index]) {
                return index
            }
            index++
        }
        return -1
    }

}