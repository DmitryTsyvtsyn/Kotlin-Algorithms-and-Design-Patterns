package design_patterns

/**
 *
 * pattern: Command
 *
 * description: it's a behavioral pattern that allows you to wrap requests or simple operations in separate objects.
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
