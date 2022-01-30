package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class LevenshteinLengthTest {

    private val levenshteinLength = LevenshteinLength()

    @Test
    fun test_some_changes() {
        val str1 = "hello"
        val str2 = "hello,"
        assertEquals(1, levenshteinLength.compute(str1, str2))

        val str3 = "hello, world!"
        val str4 = "hello, friend"
        assertEquals(6, levenshteinLength.compute(str3, str4))
    }

    @Test
    fun test_no_changes() {
        val str1 = "hello"
        assertEquals(0, levenshteinLength.compute(str1, str1))
    }

}