package search

/**
 *
 * Binary search algorithm only works for sorted lists and arrays
 *
 * best time: 1
 * worst time: log(n)
 * amount of memory: 1
 *
 */

class BinarySearch {

    // searches for an element in the array and returns the index of the searched element or -1
    fun <T : Comparable<T>> search(array: Array<T>, element: T) : Int {
        if (array.isEmpty()) return -1

        var left = 0
        var right = array.size
        while (left < right) {
            val middle = left + (right - left) / 2
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

    // recursive method
    // P.S. The tailrec modifier tells the compiler to optimize the recursion and turn it into an iterative version
    tailrec fun <T : Comparable<T>> searchRecursive(array: Array<T>, element: T, left: Int = 0, right: Int = array.size - 1): Int {
        if (left <= right) {
            val middle = left + (right - left) / 2
            if (array[middle] == element) {
                return middle
            }
            return if (array[middle] > element) {
                searchRecursive(array, element, left, middle - 1)
            } else {
                searchRecursive(array, element, middle + 1, right)
            }
        }
        return -1
    }

    // finds the left border index to insert an element into a sorted array
    fun <T : Comparable<T>> leftBound(array: Array<T>, element: T) : Int {
        if (array.isEmpty()) return 0

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

    // finds the right border index to insert an element into a sorted array
    fun <T : Comparable<T>> rightBound(array: Array<T>, element: T) : Int {
        if (array.isEmpty()) return -1

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

}