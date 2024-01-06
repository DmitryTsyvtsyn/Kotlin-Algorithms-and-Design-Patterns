package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class ParenthesisCheckTest {

    private val parenthesisCheck = ParenthesisCheck()

    @Test
    fun test_default_c_program() {
        assertEquals(true, parenthesisCheck.check())
    }

    @Test
    fun test_failed_c_program() {
        val failCode = """
            void main({
                printf("Hello, World!";
            }
        """.trimIndent()
        assertEquals(false, parenthesisCheck.check(failCode))
    }

    @Test
    fun test_statement_1() {
        val statement = "(([[]])}".trimIndent()
        assertEquals(false, parenthesisCheck.check(statement))
    }

    @Test
    fun test_statement_2() {
        val statement = "(([[()]])){}{}()".trimIndent()
        assertEquals(true, parenthesisCheck.check(statement))
    }

    @Test
    fun test_statement_3() {
        val statement = "(([[()]])){}{}([)".trimIndent()
        assertEquals(false, parenthesisCheck.check(statement))
    }

    @Test
    fun test_statement_4() {
        val statement = "(([[()]]))("
        assertEquals(false, parenthesisCheck.check(statement))
    }

    @Test
    fun test_statement_5() {
        val statement = "[]{"
        assertEquals(false, parenthesisCheck.check(statement))
    }

}