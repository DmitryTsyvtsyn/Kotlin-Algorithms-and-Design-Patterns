import sorting.mergeSort

fun main() {
    val array = arrayOf(5, 4, 3, 2, 1, 0)
    array.mergeSort()
    print(array.toList())
}