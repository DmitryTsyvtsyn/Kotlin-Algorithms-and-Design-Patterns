package structures

import org.junit.Test
import org.junit.Assert.assertEquals

internal class MinHeapTest {

    @Test
    fun `test operations`() {
        val heap = MinHeap(10)

        assertEquals(true, heap.isEmpty)

        heap.add(10)
        heap.add(17)
        heap.add(20)

        assertEquals(false, heap.isEmpty)

        assertEquals(10, heap.peekMin())
        assertEquals(10, heap.popMin())

        heap.add(1)
        heap.add(5)

        assertEquals(1, heap.peekMin())
        assertEquals(1, heap.popMin())

        assertEquals(5, heap.peekMin())
        assertEquals(5, heap.popMin())

        heap.set(1, 15)

        assertEquals(15, heap.peekMin())
        assertEquals(15, heap.popMin())

        assertEquals(20, heap.peekMin())
        assertEquals(20, heap.popMin())

        assertEquals(true, heap.isEmpty)
    }

    @Test
    fun `test creating from array`() {
        val array = intArrayOf(10, 2, 11, 17, 5, -1, 9, 0)

        val heap = MinHeap.create(array)

        assertEquals(-1, heap.popMin())
        assertEquals(0, heap.popMin())
        assertEquals(2, heap.popMin())
        assertEquals(5, heap.popMin())
        assertEquals(9, heap.popMin())
        assertEquals(10, heap.popMin())
        assertEquals(11, heap.popMin())
        assertEquals(17, heap.popMin())

        assertEquals(true, heap.isEmpty)

    }

}