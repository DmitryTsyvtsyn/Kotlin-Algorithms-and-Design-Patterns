package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MaxTest {

    private val max = Max<Int>()

    @Test
    fun test_natural_ordered() {
        val items = listOf(6, 5, 4, 3, 2, 1)
        assertEquals(6, max.compute(items))
    }

    @Test
    fun test_reversed() {
        val items = listOf(1, 2, 3, 4)
        assertEquals(4, max.compute(items))
    }

}