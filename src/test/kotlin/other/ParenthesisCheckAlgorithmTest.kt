package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class ParenthesisCheckAlgorithmTest {

    private val parenthesisCheckAlgorithm = ParenthesisCheckAlgorithm()

    @Test
    fun `test success`() {
        // the correct C program
        assertEquals(true, parenthesisCheckAlgorithm.check("""
            void main() {
                printf("Hello, World!");
            }
        """))
        assertEquals(true, parenthesisCheckAlgorithm.check(""))
        assertEquals(true, parenthesisCheckAlgorithm.check("()"))
        assertEquals(true, parenthesisCheckAlgorithm.check("{}"))
        assertEquals(true, parenthesisCheckAlgorithm.check("[]"))
        assertEquals(true, parenthesisCheckAlgorithm.check("(([[]]))[[]]"))
        assertEquals(true, parenthesisCheckAlgorithm.check("[[[[((()))]]]]{}{}{}"))
        assertEquals(true, parenthesisCheckAlgorithm.check("(())()()[][]{{()}}{}"))
    }

    @Test
    fun `test failed`() {
        // the failed C program
        assertEquals(false, parenthesisCheckAlgorithm.check("""
            void main({
                printf("Hello, World!";
            }
        """))
        assertEquals(false, parenthesisCheckAlgorithm.check("("))
        assertEquals(false, parenthesisCheckAlgorithm.check(")"))
        assertEquals(false, parenthesisCheckAlgorithm.check("{"))
        assertEquals(false, parenthesisCheckAlgorithm.check("}"))
        assertEquals(false, parenthesisCheckAlgorithm.check("["))
        assertEquals(false, parenthesisCheckAlgorithm.check("]"))
        assertEquals(false, parenthesisCheckAlgorithm.check("[](){{}"))
        assertEquals(false, parenthesisCheckAlgorithm.check("[[[]]]{}{})"))
        assertEquals(false, parenthesisCheckAlgorithm.check("{{{}}}({[}]))[]"))
    }

}