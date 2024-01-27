package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class LevenshteinLengthAlgorithmTest {

    @Test
    fun test() {
        val levenshteinLengthAlgorithm = LevenshteinLengthAlgorithm()

        val str1 = "hello"
        val str2 = "hello,"
        assertEquals(1, levenshteinLengthAlgorithm.compute(str1, str2))

        val str3 = "hello, world!"
        val str4 = "hello, friend"
        assertEquals(6, levenshteinLengthAlgorithm.compute(str3, str4))

        assertEquals(0, levenshteinLengthAlgorithm.compute(str1, str1))
        assertEquals(0, levenshteinLengthAlgorithm.compute(str2, str2))
        assertEquals(0, levenshteinLengthAlgorithm.compute(str3, str3))
        assertEquals(0, levenshteinLengthAlgorithm.compute(str4, str4))
    }

}