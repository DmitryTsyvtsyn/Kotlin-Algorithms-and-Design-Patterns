package other

import org.junit.Test
import org.junit.Assert.assertEquals

class PalindromeAlgorithmTest {

    private val palindromeAlgorithm = PalindromeAlgorithm()

    @Test
    fun `test empty string`() {
        assertEquals(true, palindromeAlgorithm.isPalindrome(""))

        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion(""))
    }

    @Test
    fun `test string with one symbol`() {
        assertEquals(true, palindromeAlgorithm.isPalindrome("a"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("b"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("c"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("d"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("e"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("f"))

        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("a"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("b"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("c"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("d"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("e"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("f"))

    }

    @Test
    fun `test string is palindrome`() {
        assertEquals(true, palindromeAlgorithm.isPalindrome("tenet"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("madam"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("racecar"))
        assertEquals(true, palindromeAlgorithm.isPalindrome("dad"))

        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("tenet"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("madam"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("racecar"))
        assertEquals(true, palindromeAlgorithm.isPalindromeSimplifiedVersion("dad"))
    }

    @Test
    fun `test string is not palindrome`() {
        assertEquals(false, palindromeAlgorithm.isPalindrome("friend"))
        assertEquals(false, palindromeAlgorithm.isPalindrome("success"))
        assertEquals(false, palindromeAlgorithm.isPalindrome("mistake"))
        assertEquals(false, palindromeAlgorithm.isPalindrome("language"))

        assertEquals(false, palindromeAlgorithm.isPalindromeSimplifiedVersion("friend"))
        assertEquals(false, palindromeAlgorithm.isPalindromeSimplifiedVersion("success"))
        assertEquals(false, palindromeAlgorithm.isPalindromeSimplifiedVersion("mistake"))
        assertEquals(false, palindromeAlgorithm.isPalindromeSimplifiedVersion("language"))
    }

}


