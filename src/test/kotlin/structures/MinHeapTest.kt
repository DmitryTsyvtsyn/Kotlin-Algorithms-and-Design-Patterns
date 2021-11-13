package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*

internal class MinHeapTest {

    @Test
    fun test_add() {
        val heap = MinHeap(1)

        assertEquals(true, heap.isEmpty())

        heap.add(10)

        assertEquals(false, heap.isEmpty())
    }

    @Test
    fun test_min() {
        val heap = MinHeap(5)

        heap.add(10)
        heap.add(4)
        heap.add(12)
        heap.add(1)
        heap.add(5)

        assertEquals(1, heap.min())
    }

    @Test
    fun test_remove() {
        val heap = MinHeap(3)

        heap.add(3)
        heap.add(2)
        heap.add(10)

        print("element -> ${heap.remove()}")

        heap.info()
        print("element -> ${heap.remove()}")
        print("element -> ${heap.remove()}")
//        assertEquals(2, heap.min())
//
//        heap.remove()
//
//        heap.info()
//
//        assertEquals(3, heap.min())
//
//        heap.remove()
//
//        assertEquals(10, heap.min())
//
//        heap.remove()
//
//        assertEquals(true, heap.isEmpty())
    }
}