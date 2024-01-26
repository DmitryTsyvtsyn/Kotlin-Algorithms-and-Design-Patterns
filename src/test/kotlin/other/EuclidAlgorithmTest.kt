package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class EuclidAlgorithmTest {

    private val euclidAlgorithm = EuclidAlgorithm()

    @Test
    fun `test computeByDivisionWithRemainder`() {
        assertEquals(5, euclidAlgorithm.computeByDivisionWithRemainder(10, 5))
        assertEquals(10, euclidAlgorithm.computeByDivisionWithRemainder(10, 100))
        assertEquals(9, euclidAlgorithm.computeByDivisionWithRemainder(9, 27))
        assertEquals(13, euclidAlgorithm.computeByDivisionWithRemainder(26, 39))
        assertEquals(1, euclidAlgorithm.computeByDivisionWithRemainder(135, 13))
        assertEquals(1, euclidAlgorithm.computeByDivisionWithRemainder(27, 19))
        assertEquals(1, euclidAlgorithm.computeByDivisionWithRemainder(2, 17))
        assertEquals(1, euclidAlgorithm.computeByDivisionWithRemainder(4, 9))
    }

    @Test
    fun `test computeBySubtraction`() {
        assertEquals(5, euclidAlgorithm.computeBySubtraction(10, 5))
        assertEquals(10, euclidAlgorithm.computeBySubtraction(10, 100))
        assertEquals(9, euclidAlgorithm.computeBySubtraction(9, 27))
        assertEquals(13, euclidAlgorithm.computeBySubtraction(26, 39))
        assertEquals(1, euclidAlgorithm.computeBySubtraction(135, 13))
        assertEquals(1, euclidAlgorithm.computeBySubtraction(27, 19))
        assertEquals(1, euclidAlgorithm.computeBySubtraction(2, 17))
        assertEquals(1, euclidAlgorithm.computeBySubtraction(4, 9))
    }

}