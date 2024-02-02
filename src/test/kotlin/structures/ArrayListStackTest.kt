package structures

import org.junit.Test
import org.junit.Assert.assertEquals

class ArrayListStackTest {

    @Test
    fun test() {
        val stack = ArrayListStack<Int>()

        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(false, stack.isEmpty)
        assertEquals(3, stack.size)

        assertEquals(3, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())

        assertEquals(true, stack.isEmpty)
        assertEquals(0, stack.size)

        stack.push(10)
        stack.push(20)
        stack.push(30)

        assertEquals(3, stack.size)
        assertEquals(30, stack.peek())
        assertEquals(3, stack.size)

        stack.clear()

        assertEquals(true, stack.isEmpty)
        assertEquals(0, stack.size)
    }

}