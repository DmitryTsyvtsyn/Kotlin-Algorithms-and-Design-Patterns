package search

/**
 * name: binary search algorithm implemented in a recursive way
 *
 * worst time: log(n)
 * amount of memory: log(n) - recursion stack
 */

class BinarySearchRecursive<T : Comparable<T>>  {

    /**
     * searches for an element [element] in an array [array] and returns the index of the searched element or -1
     */
    fun search(array: Array<T>, element: T): Int {
        return searchRecursive(array, 0, array.size - 1, element)
    }

    /**
     * checks if an element [element] is in an array [array] and returns true if the element is present in the array, false otherwise
     */
    fun exists(array: Array<T>, element: T): Boolean {
        return searchRecursive(array, 0, array.size - 1, element) != -1
    }

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