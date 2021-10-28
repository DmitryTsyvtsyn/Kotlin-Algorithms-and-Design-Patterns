package search

class BinarySearchRecursive<T : Comparable<T>> : Search<T>  {

    override fun search(array: Array<T>, element: T): Int {
        return searchRecursive(array, 0, array.size - 1, element)
    }

    override fun exists(array: Array<T>, element: T): Boolean {
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