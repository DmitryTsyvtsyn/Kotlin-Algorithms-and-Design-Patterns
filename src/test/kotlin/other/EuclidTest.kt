package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class EuclidTest {

    private val euclid = Euclid()

    @Test
    fun `test computeByDivisionWithRemainder`() {
        assertEquals(5, euclid.computeByDivisionWithRemainder(10, 5))
        assertEquals(10, euclid.computeByDivisionWithRemainder(10, 100))
        assertEquals(9, euclid.computeByDivisionWithRemainder(9, 27))
        assertEquals(13, euclid.computeByDivisionWithRemainder(26, 39))
        assertEquals(1, euclid.computeByDivisionWithRemainder(135, 13))
        assertEquals(1, euclid.computeByDivisionWithRemainder(27, 19))
        assertEquals(1, euclid.computeByDivisionWithRemainder(2, 17))
        assertEquals(1, euclid.computeByDivisionWithRemainder(4, 9))
    }

    @Test
    fun `test computeBySubtraction`() {
        assertEquals(5, euclid.computeBySubtraction(10, 5))
        assertEquals(10, euclid.computeBySubtraction(10, 100))
        assertEquals(9, euclid.computeBySubtraction(9, 27))
        assertEquals(13, euclid.computeBySubtraction(26, 39))
        assertEquals(1, euclid.computeBySubtraction(135, 13))
        assertEquals(1, euclid.computeBySubtraction(27, 19))
        assertEquals(1, euclid.computeBySubtraction(2, 17))
        assertEquals(1, euclid.computeBySubtraction(4, 9))
    }

}