package sorting

interface SortAlgo<T : Comparable<T>> {
    fun sort(array: Array<T>) : Array<T>
}