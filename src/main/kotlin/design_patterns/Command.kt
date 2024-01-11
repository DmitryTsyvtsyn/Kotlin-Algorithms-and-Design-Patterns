package design_patterns

/**
 *
 * Command is a behavioral pattern that allows you to wrap requests or simple operations in separate objects
 *
 * P.S. Kotlin variant of this pattern is shown in tests
 *
 */

interface ArithmeticCommand {
    fun execute(number: Int) : Int
}

class AddCommand(private val addendum: Int) : ArithmeticCommand {
    override fun execute(number: Int): Int {
        return number + addendum
    }
}

class MinusCommand(private val subtrahend: Int) : ArithmeticCommand {
    override fun execute(number: Int): Int {
        return number - subtrahend
    }
}

class MultiCommand(private val coefficient: Int) : ArithmeticCommand {
    override fun execute(number: Int): Int {
        return number * coefficient
    }
}

// we can also create the command that accepts others
class MacroCommand(private vararg val commands: ArithmeticCommand) : ArithmeticCommand {
    override fun execute(number: Int): Int {
        var result = number
        commands.forEach {
            result = it.execute(result)
        }
        return result
    }
}
