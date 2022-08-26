package sorting

import java.lang.Integer.min

/**
 * Tim sort algorithm
 *
 * the best time: n
 * average time: n * log(n)
 * worst time: n * log(n)
 *
 * amount of memory: n
 *
 */

fun Array<Int>.timSort() {
    val size = size
    val minrun = minrun(size)
    var index = 0
    while (index < size) {
        insertionSort(this, index, min(index + minrun - 1, size - 1))
        index += minrun
    }

    var mergingSize = minrun
    while (mergingSize < size) {

        var left = 0
        while (left < size) {
            val middle = left + mergingSize - 1
            val right = min(left + 2 * mergingSize - 1, size - 1)
            if (middle < right) {
                merge(this, left, middle, right)
            }
            left += mergingSize * 2
        }

        mergingSize *= 2
    }
}

private fun minrun(n: Int) : Int {
    var addedValue = 0
    var size = n
    if (size >= 64) {
        addedValue = addedValue or (size and 1)
        size = size.shr(1)
    }
    return size + addedValue
}

private fun insertionSort(array: Array<Int>, left: Int, right: Int) {
    var outerIndex = left + 1
    while (outerIndex <= right) {
        val temporaryValue = array[outerIndex]
        var innerIndex = outerIndex - 1
        while (innerIndex >= left && array[innerIndex] > temporaryValue) {
            array[innerIndex + 1] = array[innerIndex]
            innerIndex--
        }
        array[innerIndex + 1] = temporaryValue
        outerIndex++
    }
}

private fun merge(array: Array<Int>, left: Int, middle: Int, right: Int) {
    val leftLengthArray = middle - left + 1
    val rightLengthArray = right - middle

    var index = 0
    var leftArray = Array(leftLengthArray) { 0 }
    while (index < leftLengthArray) {
        leftArray[index] = array[left + index]
        index++
    }

    index = 0
    var rightArray = Array(rightLengthArray) { 0 }
    while (index < rightLengthArray) {
        rightArray[index] = array[middle + 1 + index]
        index++
    }

    var leftArrayIndex = 0
    var rightArrayIndex = 0
    index = 0

    while (leftArrayIndex < leftLengthArray && rightArrayIndex < rightLengthArray) {
        if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
            array[index] = leftArray[leftArrayIndex]
            leftArrayIndex++
        } else {
            array[index] = rightArray[rightArrayIndex]
            rightArrayIndex++
        }
        index++
    }

    while (leftArrayIndex < leftLengthArray) {
        array[index] = leftArray[leftArrayIndex]
        leftArrayIndex++
        index++
    }

    while (rightArrayIndex < rightLengthArray) {
        array[index] = rightArray[rightArrayIndex]
        rightArrayIndex++
        index++
    }
}