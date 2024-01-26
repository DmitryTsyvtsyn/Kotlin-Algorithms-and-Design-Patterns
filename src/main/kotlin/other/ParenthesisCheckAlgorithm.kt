package other

/**
 *
 * Algorithm for checking a string for correct placement of parentheses using stack
 *
 * ([]) - correctly
 * ()(){} - correctly
 * (() - incorrectly
 * (())[][]}{ - incorrectly
 *
 */

class ParenthesisCheckAlgorithm {

    fun check(code: String = DEFAULT_CODE): Boolean {
        // we use a regular kotlin list to create a stack
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
        // the correct C program
        private const val DEFAULT_CODE = """
            void main() {
                printf("Hello, World!");
            }
        """

        private val bracketRelations = mapOf('(' to ')', '{' to '}', '[' to ']')
    }

}