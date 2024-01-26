package other

/**
 *
 * Algorithm for checking a string for a palindrome
 *
 * P.S. A palindrome is a word, number, phrase, or other sequence of symbols
 * that reads the same backwards as forwards, such as "madam"
 */

class PalindromeAlgorithm {

    // checks a string for a palindrome and returns true if the string is a palindrome
    fun isPalindrome(text: String): Boolean {
        if (text.length <= 1) {
            return true
        }

        val length = text.length
        for (index in 0 until length / 2) {
            if (text[index] != text[length - index - 1]) {
                return false
            }
        }

        return true
    }

    fun isPalindromeSimplifiedVersion(text: String): Boolean {
        return text == text.reversed()
    }

}