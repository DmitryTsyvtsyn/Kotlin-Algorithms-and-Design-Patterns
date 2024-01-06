package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class StringEqualsHashTest {

    private val stringEqualsHash = StringEqualsHash()

    @Test
    fun test_two_the_same_strings() {
        val str1 = "Twilight Sparkle"
        val str2 = "Twilight Sparkle"

        assertEquals(true, stringEqualsHash.equals(str1, str2))
    }

    @Test
    fun test_two_different_strings() {
        val greeting = "How are you?"
        val pattern = "Happy birthday to me!"

        assertEquals(false, stringEqualsHash.equals(greeting, pattern))
    }

}