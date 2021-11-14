package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*

internal class MinHeapTest {

    @Test
    fun test_add() {
        val heap = MaxHeap(2)

        assertEquals(true, heap.isEmpty())

        heap.add(2)
        heap.add(6)

        assertEquals(false, heap.isEmpty())

    }

    @Test
    fun test_peek_min() {
        val heap = MinHeap(6)

        heap.add(17)
        heap.add(2)
        heap.add(100)

        assertEquals(2, heap.peekMin())

        heap.add(1)
        heap.add(200)

        assertEquals(1, heap.peekMin())

        heap.add(0)

        assertEquals(0, heap.peekMin())

    }

    @Test
    fun test_pop_min() {
        val heap = MinHeap(8).apply {
            add(10)
            add(40)
            add(1)
            add(1000)
            add(555)
            add(5)
            add(7)
            add(2)
        }

        assertEquals(1, heap.popMin())
        assertEquals(2, heap.popMin())
        assertEquals(5, heap.popMin())
        assertEquals(7, heap.popMin())
        assertEquals(10, heap.popMin())
        assertEquals(40, heap.popMin())
        assertEquals(555, heap.popMin())
        assertEquals(1000, heap.popMin())

        assertEquals(true, heap.isEmpty())

    }

}