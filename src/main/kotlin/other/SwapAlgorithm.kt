package other

/**
 *
 * Algorithm for exchanging two variables without a third additional
 *
 */

class SwapAlgorithm {

    // swaps two list values at the specified indexes
    fun swap(list: MutableList<Int>, oldIndex: Int, newIndex: Int) {
        if (oldIndex in list.indices && newIndex in list.indices) {
            list[oldIndex] = list[oldIndex] + list[newIndex]
            list[newIndex] = list[oldIndex] - list[newIndex]
            list[oldIndex] = list[oldIndex] - list[newIndex]
        }
    }

    // swaps two array values at the specified indexes
    fun swap(array: Array<Int>, oldIndex: Int, newIndex: Int) {
        if (oldIndex in array.indices && newIndex in array.indices) {
            array[oldIndex] = array[oldIndex] + array[newIndex]
            array[newIndex] = array[oldIndex] - array[newIndex]
            array[oldIndex] = array[oldIndex] - array[newIndex]
        }
    }

    // swaps two list values using Kotlin language features
    fun swapKotlin(list: MutableList<Int>, oldIndex: Int, newIndex: Int) {
        if (oldIndex in list.indices && newIndex in list.indices) {
            list[oldIndex] = list[newIndex].apply {
                list[newIndex] = list[oldIndex]
            }
        }
    }

    // swaps two array values using Kotlin language features
    fun swapKotlin(array: Array<Int>, oldIndex: Int, newIndex: Int) {
        if (oldIndex in array.indices && newIndex in array.indices) {
            array[oldIndex] = array[newIndex].apply {
                array[newIndex] = array[oldIndex]
            }
        }
    }

}