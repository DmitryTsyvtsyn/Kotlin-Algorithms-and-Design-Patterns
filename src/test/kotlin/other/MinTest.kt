package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MinTest {

    private val min = Min<Int>()

    @Test
    fun test_sorted() {
        val items = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(1, min.compute(items))
    }

    @Test
    fun test_reversed() {
        val items = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        assertEquals(1, min.compute(items))
    }

    @Test
    fun test_sorted_recursive() {
        val items = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(1, min.computeRecursive(items))
    }

    @Test
    fun test_reversed_recursive() {
        val items = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        assertEquals(1, min.computeRecursive(items))
    }
}