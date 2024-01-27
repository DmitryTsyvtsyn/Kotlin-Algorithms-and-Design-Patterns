package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class MinAlgorithmTest {

    private val minAlgorithm = MinAlgorithm()

    @Test
    fun `test iterative algorithm`() {
        val actual1 = minAlgorithm.compute(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        assertEquals(1, actual1)

        val actual2 = minAlgorithm.compute(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        assertEquals(1, actual2)

        val actual3 = minAlgorithm.compute(listOf(-50, 10, 6, -100, -9, 110))
        assertEquals(-100, actual3)
    }

    @Test
    fun `test recursive algorithm`() {
        val actual1 = minAlgorithm.computeRecursive(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        assertEquals(1, actual1)

        val actual2 = minAlgorithm.computeRecursive(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        assertEquals(1, actual2)

        val actual3 = minAlgorithm.computeRecursive(listOf(-50, 10, 6, -100, -9, 110))
        assertEquals(-100, actual3)
    }

}