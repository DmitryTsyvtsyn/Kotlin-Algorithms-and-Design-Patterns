package search

import org.junit.Test
import org.junit.Assert.assertEquals

internal class BinarySearchTest {

    private val searchAlgo = BinarySearch()

    @Test
    fun `test search`() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        assertEquals(-1, searchAlgo.search(emptyArray(), 0))
        assertEquals(-1, searchAlgo.search(array, 0))
        assertEquals(-1, searchAlgo.search(array, 11))
        assertEquals(0, searchAlgo.search(array, 1))
        assertEquals(2, searchAlgo.search(array, 3))
        assertEquals(4, searchAlgo.search(array, 5))
        assertEquals(6, searchAlgo.search(array, 7))
        assertEquals(8, searchAlgo.search(array, 9))
        assertEquals(9, searchAlgo.search(array, 10))

        assertEquals(-1, searchAlgo.searchRecursive(emptyArray(), 0))
        assertEquals(-1, searchAlgo.searchRecursive(array, 0))
        assertEquals(-1, searchAlgo.searchRecursive(array, 11))
        assertEquals(0, searchAlgo.searchRecursive(array, 1))
        assertEquals(2, searchAlgo.searchRecursive(array, 3))
        assertEquals(4, searchAlgo.searchRecursive(array, 5))
        assertEquals(6, searchAlgo.searchRecursive(array, 7))
        assertEquals(8, searchAlgo.searchRecursive(array, 9))
        assertEquals(9, searchAlgo.searchRecursive(array, 10))
    }

    @Test
    fun `test bounds`() {
        val array = arrayOf(1, 2, 3, 4, 6, 7, 8, 10)
        assertEquals(-1, searchAlgo.leftBound(array, 0))
        assertEquals(-1, searchAlgo.leftBound(array, 1))
        assertEquals(1, searchAlgo.leftBound(array, 3))
        assertEquals(3, searchAlgo.leftBound(array, 5))
        assertEquals(6, searchAlgo.leftBound(array, 10))
        assertEquals(7, searchAlgo.leftBound(array, 11))
        assertEquals(7, searchAlgo.leftBound(array, 100))

        assertEquals(0, searchAlgo.rightBound(array, 0))
        assertEquals(0, searchAlgo.rightBound(array, 1))
        assertEquals(2, searchAlgo.rightBound(array, 3))
        assertEquals(4, searchAlgo.rightBound(array, 5))
        assertEquals(7, searchAlgo.rightBound(array, 10))
        assertEquals(8, searchAlgo.rightBound(array, 11))
        assertEquals(8, searchAlgo.rightBound(array, 100))
    }

}