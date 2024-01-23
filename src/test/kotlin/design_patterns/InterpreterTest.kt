package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class InterpreterTest {

    @Test
    fun test() {
        // x = 10, y = 20, d = 5
        // sum = x + y
        // result = sum * d
        val expression = PerformExpression(
            SetIntVariableExpression("x", 10),
            SetIntVariableExpression("y", 20),
            AddVariablesExpression("x", "y", "sum"),
            SetIntVariableExpression("d", 5),
            MultipleVariablesExpression("sum", "d", "result")
        )

        val context = InterpreterContext()

        expression.interpret(context)

        assertEquals(150, context.fetchVariable("result"))
    }

}