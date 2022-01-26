package ru.search

import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class BinarySearchRecursiveTest {

    private val searchAlgo = BinarySearchRecursive<Int>()

    @Test
    fun test_existed_element() {
        val array = arrayOf(1, 2, 3, 4, 5)
        Assertions.assertEquals(true, searchAlgo.exists(array, 4))
    }

    @Test
    fun test_start_element() {
        val array = arrayOf(1, 11, 111, 1111, 11111)
        Assertions.assertEquals(true, searchAlgo.exists(array, 1))
    }

    @Test
    fun test_last_element() {
        val array = arrayOf(0, 5, 10)
        Assertions.assertEquals(true, searchAlgo.exists(array, 10))
    }

    @Test
    fun test_none_existed_element() {
        val array = arrayOf(0, 5, 10, 15, 20, 25)
        Assertions.assertEquals(false, searchAlgo.exists(array, 100))
    }

}