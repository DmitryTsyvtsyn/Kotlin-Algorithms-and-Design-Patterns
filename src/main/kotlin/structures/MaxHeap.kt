package structures

/**
 * data structure: max-heap
 *
 * | operation                         | time
 * ----------------------------------------------
 * | getting the maximum element       | O(1)
 * | --------------------------------------------
 * | inserting a new element           | O(logn)
 * | --------------------------------------------
 * | deleting an element               | O(logn)
 *
 * description: max-heap is a binary tree in which each parent is greater than its children
 *
 */

class MaxHeap(private val maxSize: Int) {
    private val heap = Array(maxSize + 1) { 0 }.apply {
        this[0] = Int.MAX_VALUE
    }

    private val root = 1
    private var size = 0

    private fun parent(pos: Int) = pos / 2
    private fun leftChild(pos: Int) = 2 * pos
    private fun rightChild(pos: Int) = 2 * pos + 1

    private fun swap(old: Int, new: Int) {
        heap[old] = heap[new].apply { heap[new] = heap[old] }
    }

    fun isEmpty() = size == 0

    fun add(element: Int) {
        fun heapifyUp(pos: Int) {
            var current = pos
            val temp = heap[pos]
            while (current > 0 && temp > heap[parent(current)]) {
                heap[current] = heap[parent(current)]
                current = parent(current)
            }
            heap[current] = temp
        }

        heap[++size] = element
        heapifyUp(size)
    }

    fun peekMax() = heap[root]

    fun popMax(): Int {
        fun downHeapify(pos: Int) {
            if (pos >= size / 2 && pos <= size) return
            if (pos == maxSize - 1) return

            if (heap[pos] < heap[leftChild(pos)] ||
                heap[pos] < heap[rightChild(pos)]
            ) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos))
                    downHeapify(leftChild(pos))
                } else {
                    swap(pos, rightChild(pos))
                    downHeapify(rightChild(pos))
                }
            }
        }

        val max = heap[root]
        heap[root] = heap[size--]
        downHeapify(root)
        return max
    }


}