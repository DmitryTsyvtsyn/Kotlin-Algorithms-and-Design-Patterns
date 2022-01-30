package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import java.lang.IllegalStateException

class LinkedListQueueTest {
    private val queue : Queue<Int> = Queue.LinkedListQueue()

    @BeforeEach
    fun clear() = queue.clear()

    @Test
    fun test_is_empty() {
        Assertions.assertEquals(true, queue.isEmpty())

        queue.offer(1)
        queue.offer(2)

        Assertions.assertEquals(false, queue.isEmpty())

    }

    @Test
    fun test_poll() {
        queue.offer(1)
        Assertions.assertEquals(1, queue.poll())
        Assertions.assertEquals(null, queue.poll())
    }

    @Test
    fun test_peek() {
        queue.offer(5)
        Assertions.assertEquals(5, queue.peek())
        queue.clear()
        Assertions.assertEquals(null, queue.peek())
    }

    @Test
    fun test_remove() {
        queue.offer(100)
        Assertions.assertEquals(100, queue.remove())

        val exception = Assertions.assertThrows(IllegalStateException::class.java) {
            queue.remove()
        }
        Assertions.assertEquals("queue is empty!", exception.message)
    }

    @Test
    fun test_element() {
        queue.offer(100)
        Assertions.assertEquals(100, queue.element())

        queue.clear()

        val exception = Assertions.assertThrows(IllegalStateException::class.java) {
            queue.element()
        }
        Assertions.assertEquals("queue is empty!", exception.message)
    }

    @Test
    fun test_remove_object() {
        queue.offer(10)
        queue.offer(20)
        queue.offer(1000)

        Assertions.assertEquals(true, queue.remove(20))
        Assertions.assertEquals(false, queue.remove(34))
    }
}