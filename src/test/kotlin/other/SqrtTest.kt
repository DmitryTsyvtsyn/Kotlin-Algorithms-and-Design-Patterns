package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class SqrtTest {

    @Test
    fun test() {
        val sqrt = Sqrt()
        assertEquals(3.0, sqrt.compute(9.0), 0.0)
        assertEquals(2.0, sqrt.compute(4.0), 0.0)
        assertEquals(6.0, sqrt.compute(36.0), 0.0)
    }

}