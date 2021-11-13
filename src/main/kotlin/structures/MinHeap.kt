package structures

import other.Swap
import java.nio.file.Files.size




/**
 * структура данных: min-куча
 *
 */

class MinHeap(private val maxSize: Int) {
    private var count = 0

    private val array = Array(maxSize + 1) { 0 }.apply {
        this[0] = Int.MIN_VALUE
    }

    private val front = 1

    fun toList() = array.toList()

    fun add(element: Int) {
        fun parent(pos: Int) = pos / 2

        if (count >= maxSize) {
            return
        }

        array[++count] = element

        var current = count

        while (array[current] < array[parent(current)]) {
            Swap().swapKotlin(array, current, parent(current))
            current = parent(current)
        }
    }

    fun isEmpty() = count == 0

    fun info() {

        for (i in 1..(count / 2)) {
            System.out.print(" PARENT : " + array[i]
                    + " LEFT CHILD : " + array[2 * i]
                    + " RIGHT CHILD :" + array[2 * i + 1]);
            System.out.println();
        }
    }

    fun remove(): Int {
        val element = array[front]

        array[front] = array[count--]

        minHeapify(front)

        return element
    }

    fun min() : Int {
        fun minHeap() {
            for (pos in (count / 2)..1) {
                minHeapify(pos);
            }
        }

        minHeap()
        return array[front]
    }

    private fun minHeapify(pos: Int) {
        if (!isLeaf(pos)) {
            if (array[pos] > array[leftChild(pos)] || array[pos] > array[rightChild(pos)]) {
                if (array[leftChild(pos)] < array[rightChild(pos)]) {
                    Swap().swapKotlin(array, pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    Swap().swapKotlin(array, pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    private fun leftChild(pos: Int) = 2 * pos
    private fun rightChild(pos: Int) = 2 * pos + 1
    private fun isLeaf(pos: Int) = pos >= (count / 2) && pos <= count


}