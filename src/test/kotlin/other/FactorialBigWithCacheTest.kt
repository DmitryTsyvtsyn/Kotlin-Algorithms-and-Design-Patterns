package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FactorialBigWithCacheTest {

    private val factorial = FactorialBigWithCache()

    @Test
    fun test() {
        assertEquals("30414093201713378043612608166064768844377641568960512000000000000", factorial.compute(50).toString())
        assertEquals("265252859812191058636308480000000", factorial.compute(30).toString())
        assertEquals("11978571669969891796072783721689098736458938142546425857555362864628009582789845319680000000000000000", factorial.compute(70).toString())
    }

}