package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions

class ArrayListStackTest {

    private val arrayListStack = Stack.ArrayListStack<Int>()

    @Test
    fun test_push() {
        arrayListStack.push(10)
        Assertions.assertEquals(10, arrayListStack.peek())
    }

    @Test
    fun test_pop() {
        arrayListStack.push(20)
        Assertions.assertEquals(20, arrayListStack.pop())
    }

    @Test
    fun test_is_empty() {
        arrayListStack.clear()
        Assertions.assertEquals(true, arrayListStack.isEmpty())
    }

    @Test
    fun test_is_not_empty() {
        arrayListStack.push(20)
        Assertions.assertEquals(false, arrayListStack.isEmpty())
    }
}