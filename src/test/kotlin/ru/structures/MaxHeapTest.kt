package ru.structures


import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MaxHeapTest {

    @Test
    fun test_add() {
        val heap = MaxHeap(2)

        assertEquals(true, heap.isEmpty())

        heap.add(2)
        heap.add(6)

        assertEquals(false, heap.isEmpty())

    }

    @Test
    fun test_peek_max() {
        val heap = MaxHeap(5)

        heap.add(17)
        heap.add(2)
        heap.add(100)

        assertEquals(100, heap.peekMax())

        heap.add(1)
        heap.add(200)

        assertEquals(200, heap.peekMax())

    }

    @Test
    fun test_pop_max() {
        val heap = MaxHeap(8).apply {
            add(10)
            add(40)
            add(1)
            add(1000)
            add(555)
            add(5)
            add(7)
            add(2)
        }

        assertEquals(1000, heap.popMax())
        assertEquals(555, heap.popMax())
        assertEquals(40, heap.popMax())
        assertEquals(10, heap.popMax())
        assertEquals(7, heap.popMax())
        assertEquals(5, heap.popMax())
        assertEquals(2, heap.popMax())
        assertEquals(1, heap.popMax())

        assertEquals(true, heap.isEmpty())

    }

}