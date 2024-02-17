package structures

import java.lang.IllegalArgumentException


/**
 *
 * Min-heap is a binary tree in which each parent is smaller than its children
 *
 */

class MinHeap(private val maxSize: Int) {

    private val data = IntArray(maxSize + 1) { Int.MAX_VALUE }

    private val root = 1
    private var size = 0

    val isEmpty: Boolean
        get() = size == 0

    private val Int.parent
        get() = this / 2

    private val Int.leftChild
        get() = this * 2

    private val Int.rightChild
        get() = this * 2 + 1

    init {
        if (maxSize <= 0) throw IllegalArgumentException("The heap must have maxSize larger than zero")

        data[0] = Int.MIN_VALUE
    }

    // Complexity: O(logn)
    fun add(element: Int) {
        if (size >= maxSize) throw IllegalStateException("The heap is full!")

        data[++size] = Int.MAX_VALUE
        set(size, element)
    }

    // Complexity: O(logn)
    fun set(index: Int, newValue: Int) {
        if (index < root || index > maxSize) throw IllegalArgumentException("The heap doesn't have the such index: $index!")
        if (newValue > data[index]) throw IllegalArgumentException("The new value $newValue is more than the previous: ${data[index]}")

        data[index] = newValue

        var current = index
        while (current > root && data[current.parent] > data[current]) {
            swap(current, current.parent)
            current = current.parent
        }
    }

    // Complexity: O(1)
    fun peekMin() = data[root]

    // Complexity: O(logn)
    fun popMin(): Int {
        if (size < 1) throw IllegalStateException("The heap is empty!")

        val max = data[root]
        data[root] = data[size--]
        heapify(root)
        return max
    }

    private tailrec fun heapify(pos: Int) {
        val leftChild = pos.leftChild
        val rightChild = pos.rightChild
        var minimum = pos

        if (leftChild <= size && data[leftChild] < data[minimum]) {
            minimum = leftChild
        }

        if (rightChild <= size && data[rightChild] < data[minimum]) {
            minimum = rightChild
        }

        if (minimum != pos) {
            swap(pos, minimum)
            heapify(minimum)
        }
    }

    private fun swap(index1: Int, index2: Int) {
        val tmp = data[index1]
        data[index1] = data[index2]
        data[index2] = tmp
    }

    companion object {
        fun create(intArray: IntArray): MinHeap {
            val arraySize = intArray.size
            val heap = MinHeap(arraySize)
            heap.size = intArray.size

            var index = 0
            while (index < arraySize) {
                heap.data[index + 1] = intArray[index]
                index++
            }

            var pos = arraySize / 2
            while (pos >= 0) {
                heap.heapify(pos)
                pos--
            }
            return heap
        }
    }

}