package search

/**
 *
 * name: binary search algorithm
 *
 * description: one of the most important features of this algorithm
 * is that it only works for sorted lists and arrays
 *
 * time: log(n)
 * amount of memory: 1
 *
 */

class BinarySearch<T : Comparable<T>> {

    /**
     * finds the left border index to insert an element [element] into a sorted array [array]
     */
    fun leftBound(array: Array<T>, element: T) : Int {
        var left = -1
        var right = array.size
        while ((right - left) > 1) {
            val middle = left + (right - left) / 2
            if (element > array[middle]) {
                left = middle
            } else {
                right = middle
            }
        }
        return left
    }

    /**
     * finds the right border index to insert an element [element] into a sorted array [array]
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
     * checks if an element [element] is in an array [array] and returns true if the element is present in the array, false otherwise
     */
    fun exists(array: Array<T>, element: T): Boolean {
        return search(array, element) != -1
    }

    /**
     * searches for an element [element] in an array [array] and returns the index of the searched element or -1
     */
    fun search(array: Array<T>, element: T) : Int {
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