package other

/**
 *
 * Algorithm for checking a string for a palindrome
 *
*/

class Palindrome(private val text: String) {

    /**
     * checks a string for a palindrome and returns true if the string is a palindrome
     */
    fun isYes() = text == text.reversed()

    /**
     * checks if a string is not a palindrome and returns true if the string is not a palindrome
     */
    fun isNot() = !isYes()

}