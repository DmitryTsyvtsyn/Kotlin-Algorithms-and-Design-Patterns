package design_patterns

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
