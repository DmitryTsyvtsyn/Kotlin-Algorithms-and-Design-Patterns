package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class SwapTest {

    private val swap = Swap()

    @Test
    fun test_list() {
        val list = mutableListOf(1, 2)
        val expected1 = listOf(1, 2)
        assertEquals(expected1, list)
        swap.swap(list, 0, 1)
        val expected2 = listOf(2, 1)
        assertEquals(expected2, list)
    }

    @Test
    fun test_array() {
        val array = arrayOf(1, 2)
        val expected1 = listOf(1, 2)
        assertEquals(expected1, array.toList())
        swap.swap(array, 0, 1)
        val expected2 = listOf(2, 1)
        assertEquals(expected2, array.toList())
    }

    @Test
    fun test_list_kotlin() {
        val list = mutableListOf(1, 2)
        val expected1 = listOf(1, 2)
        assertEquals(expected1, list)
        swap.swapKotlin(list, 0, 1)
        val expected2 = listOf(2, 1)
        assertEquals(expected2, list)
    }

    @Test
    fun test_array_kotlin() {
        val array = arrayOf(1, 2)
        val expected1 = listOf(1, 2)
        assertEquals(expected1, array.toList())
        swap.swapKotlin(array, 0, 1)
        val expected2 = listOf(2, 1)
        assertEquals(expected2, array.toList())
    }
}