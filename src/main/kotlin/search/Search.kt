package search

interface Search<T : Comparable<T>> {
    fun search(array: Array<T>, element: T) : Int
    fun exists(array: Array<T>, element: T) : Boolean
}