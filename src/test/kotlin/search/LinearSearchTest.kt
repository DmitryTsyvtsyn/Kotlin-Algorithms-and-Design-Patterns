package search

import org.junit.Test
import org.junit.Assert.assertEquals

internal class LinearSearchTest {

    @Test
    fun test() {
        val searchAlgo = LinearSearch()

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
    }


}