package search

/**
 * name: binary search algorithm
 *
 * description: one of the most important features of this algorithm
 * is that it only works for sorted lists and arrays
 *
 * time: log(n)
 * amount of memory: 1
 */

class BinarySearch<T : Comparable<T>> : Search<T> {

    /**
     * finds the left border to insert an element into a sorted array
     *
     * @array - sorted array to be searched
     * @element - the element for which the left border is being searched
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
     * finds the right border to insert an element into a sorted array
     *
     * @array - sorted array to be searched
     * @element - the element for which the right border is being searched
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
     * checks if an element is in an array
     *
     * @array - the array in which we are looking for the element
     * @element - search element
     *
     * @return returns true if the element is present in the array, false otherwise
     */
    override fun exists(array: Array<T>, element: T): Boolean {
        return search(array, element) != -1
    }

    /**
     * searches for an element in an array
     *
     * @array - array
     * @element - search element
     *
     * @return returns the index of the searched element or -1
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