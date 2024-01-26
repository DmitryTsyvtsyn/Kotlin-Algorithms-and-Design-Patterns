package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class StringEqualsHashAlgorithmTest {

    private val stringEqualsHashAlgorithm = StringEqualsHashAlgorithm()

    @Test
    fun test_two_the_same_strings() {
        val str1 = "Twilight Sparkle"
        val str2 = "Twilight Sparkle"

        assertEquals(true, stringEqualsHashAlgorithm.equals(str1, str2))
    }

    @Test
    fun test_two_different_strings() {
        val greeting = "How are you?"
        val pattern = "Happy birthday to me!"

        assertEquals(false, stringEqualsHashAlgorithm.equals(greeting, pattern))
    }

}