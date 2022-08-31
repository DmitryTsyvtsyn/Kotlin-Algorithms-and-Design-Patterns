package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MyArrayListTest {

    @Test
    fun test_add() {
        val array = MyArrayList().apply {
            for (i in 0 until 10) { add(i) }
        }
        assertEquals(5, array.get(5))
    }

    @Test
    fun test_set() {
        val array = MyArrayList().apply {
            add(1)
            add(2)
            add(3)
        }
        assertEquals(1, array.get(0))
        array.set(0, 10)
        assertEquals(10, array.get(0))
    }

    @Test
    fun test_contains() {
        val array = MyArrayList().apply {
            add(1)
            add(2)
            add(100)
        }
        assertEquals(true, array.contains(100))
        assertEquals(false, array.contains(5))
    }

    @Test
    fun test_remove() {
        val array = MyArrayList().apply {
            add(0)
            add(1)
            add(2)
            add(3)
            add(4)
        }
        assertEquals(3, array.get(3))
        array.remove(3)
        assertEquals(4, array.get(3))
        array.remove(0)
        assertEquals(1, array.get(0))
    }

    @Test
    fun test_increasing() {
        val array = MyArrayList().apply {
            for (i in 0 until 10) { add(i) }
        }
        assertEquals(false, array.contains(10))
        assertEquals(20, array.capacity())
        array.add(10)
        assertEquals(true, array.contains(10))
        assertEquals(20, array.capacity())
    }

}