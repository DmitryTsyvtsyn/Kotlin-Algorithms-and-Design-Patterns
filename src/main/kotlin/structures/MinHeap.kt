package structures


/**
 * структура данных: min-куча
 *
 * | операция                            | время
 * ----------------------------------------------
 * | получение минимального элемента    | O(1)
 * | --------------------------------------------
 * | вставка нового элемента             | O(logn)
 * | --------------------------------------------
 * | удаление элемента                   | O(logn)
 *
 * описание: min-куча является бинарным деревом, в котором каждый родитель меньше своих дочерних элементов
 */

class MinHeap(private val maxSize: Int) {
    private val heap = Array(maxSize + 1) { 0 }.apply {
        this[0] = Int.MIN_VALUE
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
            while (current > 0 && temp < heap[parent(current)]) {
                heap[current] = heap[parent(current)]
                current = parent(current)
            }
            heap[current] = temp
        }

        heap[++size] = element
        heapifyUp(size)
    }

    fun peekMin() = heap[root]

    fun popMin(): Int {
        fun downHeapify(pos: Int) {
            if (pos >= size / 2 && pos <= size) return
            if (pos == maxSize - 1) return

            if (heap[pos] > heap[leftChild(pos)] ||
                heap[pos] > heap[rightChild(pos)]
            ) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos))
                    downHeapify(leftChild(pos))
                } else {
                    swap(pos, rightChild(pos))
                    downHeapify(rightChild(pos))
                }
            }
        }

        val min = heap[root]
        heap[root] = heap[size--]
        downHeapify(root)
        return min
    }


}