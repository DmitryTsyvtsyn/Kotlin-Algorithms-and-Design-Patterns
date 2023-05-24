package other

/**
 *
 * checks a string for correct placement of parentheses using stack
 *
 * ([]) - correctly
 * ()(){} - correctly
 * (() - incorrectly
 * (())[][]}{ - incorrectly
 *
 */

class ParenthesisCheck {

    /**
     *
     * we use a regular kotlin list to create a stack
     *
     * @return returns true if parentheses are correctly spaced otherwise false
     *
     */
    fun check(code: String = defaultCode): Boolean {
        val stack = mutableListOf<Char>()

        var index = 0
        while (index < code.length) {

            when (val symbol = code[index]) {
                '(', '{', '[' -> stack.add(symbol)
                ')', '}', ']' -> {
                    val value = bracketRelations[stack.removeLastOrNull()]
                    if (symbol != value) {
                        return false
                    }
                }
            }

            index++
        }

        return stack.isEmpty()
    }

    companion object {
        /**
         *
         * correct C program
         *
         */
        private const val defaultCode = """
            void main() {
                printf("Hello, World!");
            }
        """

        private val bracketRelations = mapOf('(' to ')', '{' to '}', '[' to ']')
    }

}