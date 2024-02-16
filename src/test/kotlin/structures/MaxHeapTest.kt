package structures


import org.junit.Test
import org.junit.Assert.assertEquals

internal class MaxHeapTest {

    @Test
    fun `test operations`() {
        val heap = MaxHeap(10)

        assertEquals(true, heap.isEmpty)

        heap.add(10)
        heap.add(17)
        heap.add(20)

        assertEquals(false, heap.isEmpty)

        assertEquals(20, heap.peekMax())
        assertEquals(20, heap.popMax())

        heap.add(1)
        heap.add(5)

        assertEquals(17, heap.peekMax())
        assertEquals(17, heap.popMax())

        assertEquals(10, heap.peekMax())
        assertEquals(10, heap.popMax())

        heap.set(1, 100)

        assertEquals(100, heap.peekMax())
        assertEquals(100, heap.popMax())

        assertEquals(1, heap.peekMax())
        assertEquals(1, heap.popMax())

        assertEquals(true, heap.isEmpty)
    }

    @Test
    fun `test creating from array`() {
        val array = intArrayOf(10, 2, 11, 17, 5, -1, 9, 0)

        val heap = MaxHeap.create(array)

        assertEquals(17, heap.popMax())
        assertEquals(11, heap.popMax())
        assertEquals(10, heap.popMax())
        assertEquals(9, heap.popMax())
        assertEquals(5, heap.popMax())
        assertEquals(2, heap.popMax())
        assertEquals(0, heap.popMax())
        assertEquals(-1, heap.popMax())

        assertEquals(true, heap.isEmpty)

    }

}