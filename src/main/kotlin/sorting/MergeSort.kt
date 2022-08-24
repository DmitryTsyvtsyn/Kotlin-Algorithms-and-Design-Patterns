package sorting

fun <T : Comparable<T>> Array<T>.mergeSort() {
    val temporaryArray = this.copyOf()

    var winSize = 1
    while (winSize < size) {

        var left = 0
        while (left + winSize < size) {

            val middle = left + winSize
            var right = middle + winSize
            if (right > size) right = size

            var i = left
            var k = left
            var j = middle
            while (i < middle && j < right) {
                if (this[i] <= this[j]) {
                    temporaryArray[k] = this[i]
                    i++
                } else {
                    temporaryArray[k] = this[j]
                    j++
                }
                k++
            }

            while (i < middle) {
                temporaryArray[k] = this[i]
                i++
                k++
            }

            while (j < right) {
                temporaryArray[k] = this[j]
                j++
                k++
            }

            i = left
            while (i < right) {
                this[i] = temporaryArray[i]
                i++
            }

            left += winSize * 2
        }

        winSize *= 2
    }
}

fun <T : Comparable<T>> MutableList<T>.mergeSort() {
    val temporaryArray = this.toMutableList()

    var winSize = 1
    while (winSize < size) {

        var left = 0
        while (left + winSize < size) {

            val middle = left + winSize
            var right = middle + winSize
            if (right > size) right = size

            var i = left
            var k = left
            var j = middle
            while (i < middle && j < right) {
                if (this[i] <= this[j]) {
                    temporaryArray[k] = this[i]
                    i++
                } else {
                    temporaryArray[k] = this[j]
                    j++
                }
                k++
            }

            while (i < middle) {
                temporaryArray[k] = this[i]
                i++
                k++
            }

            while (j < right) {
                temporaryArray[k] = this[j]
                j++
                k++
            }

            i = left
            while (i < right) {
                this[i] = temporaryArray[i]
                i++
            }

            left += winSize * 2
        }

        winSize *= 2
    }
}