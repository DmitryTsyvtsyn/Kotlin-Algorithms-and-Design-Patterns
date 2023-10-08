package structures


/**
 *
 * data structure: min-heap
 *
 * | operation                       | time
 * ----------------------------------------------
 * | getting the minimum element     | O(1)
 * | --------------------------------------------
 * | inserting a new element         | O(logn)
 * | --------------------------------------------
 * | deleting an element             | O(logn)
 *
 * description: min-heap is a binary tree in which each parent is smaller than its children
 *
 */

class MinHeap(maxSize: Int) {

    private val heap = Array(maxSize) { 0 }

    private var size = 0
    private val front = 0

    fun add(item: Int) {
        heap[size++] = item

        var current = size - 1
        var parent = parent(current)

        while (parent != current && heap[current] < heap[parent]) {
            swap(current, parent)
            current = parent
            parent = parent(current)
        }
    }

    fun minHeapify(pos: Int) {
        val left = left(pos)
        val right = right(pos)

        var smallest = if (left <= size && heap[left] < heap[pos]) {
            left
        } else {
            pos
        }

        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right
        }

        if (smallest != pos) {
            swap(pos, smallest)
            minHeapify(smallest)
        }
    }

    fun popMin() : Int {
        if (size == 1) {
            return heap[--size]
        }

        val min = heap[front]
        heap[front] = heap[size - 1]

        size--

        minHeapify(front)

        return min
    }

    fun peekMin() = heap[front]

    fun isEmpty() = size == 0

    private fun left(pos: Int) = 2 * pos + 1
    private fun right(pos: Int) = 2 * pos + 2
    private fun parent(pos: Int) = if (pos % 2 == 1) pos / 2 else (pos - 1) / 2
    private fun swap(old: Int, new: Int) {
        heap[new] = heap[old].apply {
            heap[old] = heap[new]
        }
    }

}