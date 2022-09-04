package other

/**
 *
 * reverse array
 *
 * algorithm complexity: n/2 operations
 *
 */

class ReverseArray<T> {

    /**
     * creates and returns a reverse array
     *
     */
    fun compute(array: Array<T>) : Array<T> {
        val newArray = array.copyOf()
        for (index in 0 until array.size / 2) {
            newArray[index] = newArray[array.size - index - 1].apply {
                newArray[array.size - index - 1] = newArray[index]
            }
        }
        return newArray
    }
}