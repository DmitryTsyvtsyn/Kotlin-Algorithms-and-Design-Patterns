package sorting

/**
 *
 * Merge sort is a divide-and-conquer algorithm that was invented by John von Neumann in 1945
 *
 * Conceptually, a merge sort works as follows:
 *
 * 1) Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
 *
 * 2) Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining.
 * This will be the sorted list.
 *
 */

class MergeSort {

    /**
     * worst time: n * log(n)
     * best time: n * log(n)
     * average time: n * log(n)
     *
     * amount of memory: n
     */
    fun <T : Comparable<T>> sort(array: Array<T>) {
        val arraySize = array.size
        val temporaryArray = array.copyOf()

        var windowSize = 1
        while (windowSize < arraySize) {

            var left = 0
            while (left + windowSize < arraySize) {

                val middle = left + windowSize
                var right = middle + windowSize
                if (right > arraySize) right = arraySize

                var i = left
                var k = left
                var j = middle
                while (i < middle && j < right) {
                    if (array[i] <= array[j]) {
                        temporaryArray[k] = array[i]
                        i++
                    } else {
                        temporaryArray[k] = array[j]
                        j++
                    }
                    k++
                }

                while (i < middle) {
                    temporaryArray[k] = array[i]
                    i++
                    k++
                }

                while (j < right) {
                    temporaryArray[k] = array[j]
                    j++
                    k++
                }

                i = left
                while (i < right) {
                    array[i] = temporaryArray[i]
                    i++
                }

                left += windowSize * 2
            }

            windowSize *= 2
        }
    }

    /**
     * worst time: n * log(n)
     * best time: n * log(n)
     * average time: n * log(n)
     *
     * amount of memory: n * log(n)
     */
    fun sortRecursive(array: Array<Int>) {
        val arraySize = array.size

        if (arraySize < 2)
            return

        val middle = arraySize / 2

        val left = Array(middle) { 0 }
        val right = Array(arraySize - middle) { 0 }

        var i = 0
        while (i < middle) {
            left[i] = array[i]
            i++
        }

        while (i < arraySize) {
            right[i - middle] = array[i]
            i++
        }

        sortRecursive(left)
        sortRecursive(right)

        val leftSize = left.size
        val rightSize = right.size

        i = 0
        var j = 0
        var k = 0
        while (i < leftSize && j < rightSize) {
            if (left[i]  <= right[j]) {
                array[k] = left[i]
                i++
            } else {
                array[k] = right[j]
                j++
            }
            k++
        }

        while (i < leftSize) {
            array[k] = left[i]
            i++
            k++
        }

        while (j < rightSize) {
            array[k] = right[j]
            j++
            k++
        }
    }

}