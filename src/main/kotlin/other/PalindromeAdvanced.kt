package other

/**
 *
 * Algorithm for checking a string for a palindrome
 *
 */

class PalindromeAdvanced(private val text: String) {

    /**
     *
     * checks a string for a palindrome
     *
     * @return returns true if the string is a palindrome
     *
     */
    fun isYes() : Boolean {
        if (text.length <= 1) {
            return true
        }
        for (i in 0 until text.length / 2) {
            if (text[i] != text[text.length - 1 - i]) {
                return false
            }
        }
        return true
    }

    /**
     *
     * checks if a string is not a palindrome
     *
     * @return returns true if the string is not a palindrome
     *
     */
    fun isNot() = !isYes()

}