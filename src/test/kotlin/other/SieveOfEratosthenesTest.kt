package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class SieveOfEratosthenesTest {

    @Test
    fun test() {
        val eratosthenes = SieveOfEratosthenes()
        val actual = eratosthenes.compute(10)
        val expected = listOf(2, 3, 5, 7)
        assertEquals(expected, actual)
    }

}