package sorting

fun main() {
    val sort = InsertionSort<Int>()
    print(sort.sort(arrayOf(3, 2, 1)).toList())
}