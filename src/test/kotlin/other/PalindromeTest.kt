package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class PalindromeTest {

    @Test
    fun test_is_palindrome() {
        val text = "tenet"
        assertEquals(Palindrome(text).isYes(), true)
    }

    @Test
    fun test_is_not_palindrome() {
        val text = "white"
        assertEquals(Palindrome(text).isNot(), true)
    }

}