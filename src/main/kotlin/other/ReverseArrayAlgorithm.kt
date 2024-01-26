package other

/**
 *
 * Algorithm for reversing the order of an array
 *
 * complexity: O(n/2) + O(n)
 *
 */

class ReverseArrayAlgorithm {

    fun <T> compute(array: Array<T>) {
        val size = array.size
        for (index in 0 until size / 2) {
            array[index] = array[size - index - 1].apply {
                array[size - index - 1] = array[index]
            }
        }
    }

}