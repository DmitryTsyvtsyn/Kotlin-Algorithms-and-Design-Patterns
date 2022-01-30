package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FactorialWithCacheTest {

    private val factorial = FactorialWithCache()

    @Test
    fun test() {
        assertEquals(6, factorial.compute(3))
        assertEquals(120, factorial.compute(5))
        assertEquals(720, factorial.compute(6))
        assertEquals(3628800, factorial.compute(10))
    }

}