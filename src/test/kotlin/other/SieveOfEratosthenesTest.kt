package other

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals

internal class SieveOfEratosthenesTest {

    @Test
    fun test_success() {
        val eratosthenes = SieveOfEratosthenes()
        val actual = eratosthenes.compute(10)
        val expected = listOf(2, 3, 5, 7)
        assertEquals(expected, actual)
    }

    @Test
    fun test_fail() {
        val eratosthenes = SieveOfEratosthenes()
        val actual = eratosthenes.compute(5)
        val expected = listOf(4)
        assertNotEquals(expected, actual)
    }

}