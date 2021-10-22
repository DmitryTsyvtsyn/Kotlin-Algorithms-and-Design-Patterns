package sorting

class RadixSort : SortAlgo<Int>() {

    override fun sortAlgo(array: Array<Int>) {
        val array1 = Array(array.size) { 0 }
        val array2 = Array(array.size) { 0 }

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
}