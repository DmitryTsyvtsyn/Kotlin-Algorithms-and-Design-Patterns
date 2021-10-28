package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class SqrtTest {

    @Test
    fun test() {
        val sqrt = Sqrt()
        assertEquals(3.0, sqrt.compute(9.0))
        assertEquals(2.0, sqrt.compute(4.0))
        assertEquals(6.0, sqrt.compute(36.0))
    }

}