package search

class LinearSearch<T : Comparable<T>> : Search<T> {

    override fun exists(array: Array<T>, element: T) : Boolean {
        return search(array, element) != -1
    }

    override fun search(array: Array<T>, element: T) : Int {
        for (i in array.indices) {
            if (element == array[i]) {
                return i
            }
        }
        return -1
    }

}