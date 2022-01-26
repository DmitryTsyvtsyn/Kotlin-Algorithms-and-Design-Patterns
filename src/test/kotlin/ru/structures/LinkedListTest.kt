package ru.structures

import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class LinkedListTest {

    @Test
    fun test_is_empty() {
        val list = LinkedList<Int>()
        Assertions.assertEquals(true, list.isEmpty())
        list.add(10)
        Assertions.assertEquals(false, list.isEmpty())
    }

    @Test
    fun test_add() {
        val list = LinkedList<Int>()
        Assertions.assertEquals(listOf<Int>(), list.toList())
        list.add(10)
        list.add(20)
        list.add(30)
        Assertions.assertEquals(listOf(10, 20, 30), list.toList())
    }

    @Test
    fun test_add_first() {
        val list = LinkedList<Int>()
        Assertions.assertEquals(listOf<Int>(), list.toList())
        list.addFirst(30)
        list.addFirst(20)
        list.addFirst(10)
        Assertions.assertEquals(listOf(10, 20, 30), list.toList())
    }

    @Test
    fun test_remove() {
        val list = LinkedList<Int>()
        Assertions.assertEquals(listOf<Int>(), list.toList())
        list.addLast(10)
        list.addLast(20)
        list.addLast(30)
        Assertions.assertEquals(listOf(10, 20, 30), list.toList())
        list.remove(20)
        Assertions.assertEquals(listOf(10, 30), list.toList())
        list.remove(30)
        Assertions.assertEquals(listOf(10), list.toList())
        list.remove(10)
        Assertions.assertEquals(true, list.isEmpty())
    }

    @Test
    fun test_contains() {
        val list = LinkedList<Int>()
        Assertions.assertEquals(false, list.contains(10))
        list.add(10)
        Assertions.assertEquals(true, list.contains(10))
        list.addFirst(100)
        list.addLast(300)
        Assertions.assertEquals(true, list.contains(300))
        Assertions.assertEquals(false, list.contains(1000))
        list.remove(10)
        Assertions.assertEquals(false, list.contains(10))
    }

}