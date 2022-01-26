package en.sorting

abstract class SortAlgo<T : Comparable<T>> {
    fun sort(array: Array<T>) : Array<T> {
        val copy = array.copyOf()
        sortAlgo(copy)
        return copy
    }

    abstract fun sortAlgo(array: Array<T>)
}
