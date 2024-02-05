package structures

import org.junit.Test
import org.junit.Assert.assertEquals

class QueueTest {

    @Test
    fun test() {
        val queue = Queue<Int>()

        assertEquals(true, queue.isEmpty)
        assertEquals(0, queue.size)

        queue.enqueue(1)
        assertEquals(1, queue.peek())

        queue.enqueue(2)
        assertEquals(1, queue.peek())

        queue.enqueue(3)
        assertEquals(1, queue.peek())

        assertEquals(false, queue.isEmpty)
        assertEquals(3, queue.size)

        assertEquals(1, queue.dequeue())
        assertEquals(2, queue.peek())

        assertEquals(2, queue.dequeue())
        assertEquals(3, queue.peek())

        assertEquals(3, queue.dequeue())

        assertEquals(true, queue.isEmpty)
        assertEquals(0, queue.size)

        queue.enqueue(10)
        queue.enqueue(20)
        queue.enqueue(30)

        assertEquals(false, queue.isEmpty)
        assertEquals(3, queue.size)

        queue.clear()

        assertEquals(true, queue.isEmpty)
        assertEquals(0, queue.size)
    }

}