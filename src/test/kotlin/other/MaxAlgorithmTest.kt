package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class MaxAlgorithmTest {

    private val maxAlgorithm = MaxAlgorithm()

    @Test
    fun `test iterative algorithm`() {
        val actual1 = maxAlgorithm.compute(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        assertEquals(10, actual1)

        val actual2 = maxAlgorithm.compute(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        assertEquals(10, actual2)

        val actual3 = maxAlgorithm.compute(listOf(-50, 10, 6, -100, -9, 110))
        assertEquals(110, actual3)
    }

    @Test
    fun `test recursive algorithm`() {
        val actual1 = maxAlgorithm.computeRecursive(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        assertEquals(10, actual1)

        val actual2 = maxAlgorithm.computeRecursive(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        assertEquals(10, actual2)

        val actual3 = maxAlgorithm.computeRecursive(listOf(-50, 10, 6, -100, -9, 110))
        assertEquals(110, actual3)
    }

}