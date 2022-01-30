package search

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class BinarySearchTest {

    private val searchAlgo = BinarySearch<Int>()

    @Test
    fun test_existed_element() {
        val array = arrayOf(1, 2, 3, 4, 5)
        assertEquals(true, searchAlgo.exists(array, 4))
    }

    @Test
    fun test_start_element() {
        val array = arrayOf(1, 11, 111, 1111, 11111)
        assertEquals(true, searchAlgo.exists(array, 1))
    }

    @Test
    fun test_last_element() {
        val array = arrayOf(0, 5, 10)
        assertEquals(true, searchAlgo.exists(array, 10))
    }

    @Test
    fun test_none_existed_element() {
        val array = arrayOf(0, 5, 10, 15, 20, 25)
        assertEquals(false, searchAlgo.exists(array, 100))
    }

    @Test
    fun test_left_bound() {
        val array = arrayOf(1, 2, 4, 5)
        assertEquals(1, searchAlgo.leftBound(array, 3))
        assertEquals(1, searchAlgo.leftBound(array, 4))
        assertEquals(2, searchAlgo.leftBound(array, 5))
    }

    @Test
    fun test_right_bound() {
        val array = arrayOf(10, 20, 21, 22, 23)
        assertEquals(0, searchAlgo.rightBound(array, 3))
        assertEquals(1, searchAlgo.rightBound(array, 15))
        assertEquals(2, searchAlgo.rightBound(array, 21))
    }

}