package design_patterns

/**
 *
 * Interpreter is a behavioral design pattern that defines a simple language grammar for a problem domain,
 *
 * represents grammatical rules as language sentences and interprets them to solve commonly encountered problems
 *
 */

// contains general information for the interpreter
class InterpreterContext {
    private val variables = mutableMapOf<String, Int>()

    fun putVariable(key: String, value: Int) {
        variables[key] = value
    }

    fun fetchVariable(key: String): Int {
        return variables[key] ?: 0
    }
}

// represents a specific interpreter grammar expression
interface InterpreterExpression {
    fun interpret(context: InterpreterContext)
}

class SetIntVariableExpression(
    private val key: String,
    private val intValue: Int
) : InterpreterExpression {
    override fun interpret(context: InterpreterContext) {
        context.putVariable(key = key, value = intValue)
    }
}

class PerformExpression(private vararg val expressions: InterpreterExpression) : InterpreterExpression {
    override fun interpret(context: InterpreterContext) {
        expressions.forEach { it.interpret(context) }
    }
}

class AddVariablesExpression(
    private val key0: String,
    private val key1: String,
    private val result: String
) : InterpreterExpression {
    override fun interpret(context: InterpreterContext) {
        context.putVariable(
            key = result,
            value = context.fetchVariable(key0) + context.fetchVariable(key1)
        )
    }
}

class MultipleVariablesExpression(
    private val key0: String,
    private val key1: String,
    private val result: String
) : InterpreterExpression {
    override fun interpret(context: InterpreterContext) {
        context.putVariable(
            key = result,
            value = context.fetchVariable(key0) * context.fetchVariable(key1)
        )
    }
}