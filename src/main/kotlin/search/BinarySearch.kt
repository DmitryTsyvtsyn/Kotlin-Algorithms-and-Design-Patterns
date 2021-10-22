package search

class BinarySearch<T : Comparable<T>> : Search<T> {

    fun leftBound(array: Array<T>, element: T) : Int {
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
        return left
    }

    fun rightBound(array: Array<T>, element: T) : Int {
        var left = -1
        var right = array.size
        while ((right - left) > 1) {
            val middle = (right - left) / 2
            if (element > array[middle]) {
                left = middle
            } else {
                right = middle
            }
        }
        return right
    }

    override fun exists(array: Array<T>, element: T): Boolean {
        return search(array, element) != -1
    }

    override fun search(array: Array<T>, element: T) : Int {
        val leftBound = leftBound(array, element)
        val potentialIndex = leftBound + 1
        return if (potentialIndex < array.size && array[potentialIndex] == element) {
            potentialIndex
        } else {
            -1
        }
    }

}