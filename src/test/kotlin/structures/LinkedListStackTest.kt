package structures

import org.junit.Test
import org.junit.Assert.assertEquals

class LinkedListStackTest {

    private val arrayListStack = Stack.LinkedListStack<Int>()

    @Test
    fun test_push() {
        arrayListStack.push(10)
        assertEquals(10, arrayListStack.peek())
    }

    @Test
    fun test_pop() {
        arrayListStack.push(20)
        assertEquals(20, arrayListStack.pop())
    }

    @Test
    fun test_is_empty() {
        arrayListStack.clear()
        assertEquals(true, arrayListStack.isEmpty())
    }

    @Test
    fun test_is_not_empty() {
        arrayListStack.push(20)
        assertEquals(false, arrayListStack.isEmpty())
    }

}