package en.search

/**
 * name: linear search algorithm
 *
 * worst time: n
 * amount of memory: 1
 */

class LinearSearch<T : Comparable<T>> : Search<T> {

    /**
     * returns true if the element was found in the array
     *
     * @array - sorted array
     * @element - search element
     */
    override fun exists(array: Array<T>, element: T) : Boolean {
        return search(array, element) != -1
    }

    /**
     * returns the index of the searched element, otherwise -1
     *
     * @array - sorted array
     * @element - search element
     */
    override fun search(array: Array<T>, element: T) : Int {
        for (i in array.indices) {
            if (element == array[i]) {
                return i
            }
        }
        return -1
    }

}