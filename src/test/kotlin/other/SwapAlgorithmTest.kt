package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class SwapAlgorithmTest {

    private val swapAlgorithm = SwapAlgorithm()

    @Test
    fun test_list() {
        val list = mutableListOf(1, 2, 3, 4, 5, 6)
     
        swapAlgorithm.swap(list, 0, 5)
        swapAlgorithm.swap(list, 1, 4)
        swapAlgorithm.swap(list, 2, 3)
        
        assertEquals(listOf(6, 5, 4, 3, 2, 1), list)
    }

    @Test
    fun test_array() {
        val array = arrayOf(1, 2, 3, 4, 5, 6)

        swapAlgorithm.swap(array, 0, 5)
        swapAlgorithm.swap(array, 1, 4)
        swapAlgorithm.swap(array, 2, 3)
        
        assertEquals(listOf(6, 5, 4, 3, 2, 1), array.toList())
    }

    @Test
    fun test_list_kotlin() {
        val list = mutableListOf(1, 2, 3, 4, 5, 6)

        swapAlgorithm.swapKotlin(list, 0, 5)
        swapAlgorithm.swapKotlin(list, 1, 4)
        swapAlgorithm.swapKotlin(list, 2, 3)

        assertEquals(listOf(6, 5, 4, 3, 2, 1), list)
    }

    @Test
    fun test_array_kotlin() {
        val array = arrayOf(1, 2, 3, 4, 5, 6)

        swapAlgorithm.swapKotlin(array, 0, 5)
        swapAlgorithm.swapKotlin(array, 1, 4)
        swapAlgorithm.swapKotlin(array, 2, 3)

        assertEquals(listOf(6, 5, 4, 3, 2, 1), array.toList())
    }

}