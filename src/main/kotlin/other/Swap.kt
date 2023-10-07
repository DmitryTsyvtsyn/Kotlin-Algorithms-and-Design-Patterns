package other

/**
 *
 * Algorithm for exchanging two variables without a third additional
 *
 */

class Swap {

    /**
     * Kotlin Extension for checking list index for correctness
     *
     * @return returns true if the element is accessible by index
     */
    private fun  List<Int>.inIndex(index: Int) = index in indices

    /**
     * Kotlin Extension to check array index for correctness
     *
     * @return returns true if the element is accessible by index
     */
    private fun Array<Int>.inIndex(index: Int) = index in indices

    /**
     * swaps two list values at the specified indexes
     */
    fun swap(list: MutableList<Int>, old: Int, new: Int) {
        if (list.inIndex(old) && list.inIndex(new)) {
            list[old] = list[old] + list[new]
            list[new] = list[old] - list[new]
            list[old] = list[old] - list[new]
        }
    }

    /**
     * swaps two array values at the specified indexes
     */
    fun swap(array: Array<Int>, old: Int, new: Int) {
        if (array.inIndex(old) && array.inIndex(new)) {
            array[old] = array[old] + array[new]
            array[new] = array[old] - array[new]
            array[old] = array[old] - array[new]
        }
    }

    /**
     * swaps two values using Kotlin language features
     */
    fun swapKotlin(list: MutableList<Int>, old: Int, new: Int) {
        if (list.inIndex(old) && list.inIndex(new)) {
            list[old] = list[new].apply {
                list[new] = list[old]
            }
        }
    }

    /**
     * swaps two values using Kotlin language features
     */
    fun swapKotlin(array: Array<Int>, old: Int, new: Int) {
        if (array.inIndex(old) && array.inIndex(new)) {
            array[old] = array[new].apply {
                array[new] = array[old]
            }
        }
    }

}