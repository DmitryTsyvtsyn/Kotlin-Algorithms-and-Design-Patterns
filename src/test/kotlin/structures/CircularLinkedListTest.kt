package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CircularLinkedListTest {

    @Test
    fun test_is_empty() {
        val list = CircularLinkedList<Int>()
        assertEquals(true, list.isEmpty())
        list.add(10)
        assertEquals(false, list.isEmpty())
    }

    @Test
    fun test_circular() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        assertEquals(true, list.isCircular())
        list.add(2)
        list.add(3)
        assertEquals(true, list.isCircular())
        list.remove(2)
        list.remove(1)
        assertEquals(true, list.isCircular())
    }

    @Test
    fun test_size() {
        val list = CircularLinkedList<Int>()
        assertEquals(0, list.size())
        list.add(1)
        list.add(2)
        list.add(3)
        assertEquals(3, list.size())
        list.remove(2)
        assertEquals(2, list.size())
    }

    @Test
    fun test_add() {
        val list = CircularLinkedList<Int>()
        assertEquals(listOf<Int>(), list.toList())
        list.add(10)
        list.add(20)
        list.add(30)
        assertEquals(listOf(10, 20, 30), list.toList())
    }

    @Test
    fun test_add_first() {
        val list = CircularLinkedList<Int>()
        assertEquals(listOf<Int>(), list.toList())
        list.addFirst(30)
        list.addFirst(20)
        list.addFirst(10)
        assertEquals(listOf(10, 20, 30), list.toList())
    }

    @Test
    fun test_remove() {
        val list = CircularLinkedList<Int>()
        assertEquals(listOf<Int>(), list.toList())
        list.addLast(10)
        list.addLast(20)
        list.addLast(30)
        assertEquals(listOf(10, 20, 30), list.toList())
        list.remove(20)
        assertEquals(listOf(10, 30), list.toList())
        list.remove(30)
        assertEquals(listOf(10), list.toList())
        list.remove(10)
        assertEquals(true, list.isEmpty())
    }

    @Test
    fun test_contains() {
        val list = CircularLinkedList<Int>()
        assertEquals(false, list.contains(10))
        list.add(10)
        assertEquals(true, list.contains(10))
        list.addFirst(100)
        list.addLast(300)
        assertEquals(true, list.contains(300))
        assertEquals(false, list.contains(1000))
        list.remove(10)
        assertEquals(false, list.contains(10))
    }

}