package sorting

/**
 * radix sort algorithm applies only to integers
 *
 * worst time: <number of bits of an integer> * n
 *
 * amount of memory: 2 * n
 */

fun Array<Int>.radixSort() {
    val array = this
    val array1 = Array(size) { 0 }
    val array2 = Array(size) { 0 }

    val size = Int.SIZE_BITS

    for (radix in 0 until size) {
        var size1 = 0
        var size2 = 0
        for (index in array.indices) {
            if (array[index].and(1.shl(radix)) == 0) {
                array1[size1++] = array[index]
            } else {
                array2[size2++] = array[index]
            }
        }

        for (index in 0 until size1) {
            array[index] = array1[index]
        }

        for (index in 0 until size2) {
            array[size1 + index] = array2[index]
        }
    }
}

fun MutableList<Int>.radixSort() {
    val list = this
    val array1 = MutableList(size) { 0 }
    val array2 = MutableList(size) { 0 }

    val size = Int.SIZE_BITS

    for (radix in 0 until size) {
        var size1 = 0
        var size2 = 0
        for (index in list.indices) {
            if (list[index].and(1.shl(radix)) == 0) {
                array1[size1++] = list[index]
            } else {
                array2[size2++] = list[index]
            }
        }

        for (index in 0 until size1) {
            list[index] = array1[index]
        }

        for (index in 0 until size2) {
            list[size1 + index] = array2[index]
        }
    }
}