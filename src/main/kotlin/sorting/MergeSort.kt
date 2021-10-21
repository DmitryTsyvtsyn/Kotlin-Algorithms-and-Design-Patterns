package sorting

class MergeSort : SortAlgo<Int>() {

    override fun sortAlgo(array: Array<Int>) {
        if (array.size < 2)
            return

        val mid = array.size / 2

        val left = Array(mid) { 0 }
        val right = Array(array.size - mid) { 0 }

        for (i in 0 until mid) {
            left[i] = array[i]
        }

        for (i in mid until array.size) {
            right[i - mid] = array[i]
        }

        sortAlgo(left)
        sortAlgo(right)

        var i = 0; var j = 0; var k = 0

        val leftSize = left.size
        val rightSize = right.size

        while (i < leftSize && j < rightSize) {
            if (left[i]  <= right[j]) {
                array[k++] = left[i++]
            } else {
                array[k++] = right[j++]
            }
        }

        while (i < leftSize) {
            array[k++] = left[i++]
        }

        while (j < rightSize) {
            array[k++] = right[j++]
        }

    }

}