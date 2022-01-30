package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class Command {

    @Test
    fun test_1() {
        val commands = listOf(
            AddCommand(10),
            AddCommand(20),
            MultiCommand(2),
            MinusCommand(10)
        )

        var actual = 0
        commands.forEach { command ->
            actual = command.execute(actual)
        }

        Assertions.assertEquals(50, actual)
    }

    @Test
    fun test_2() {
        val commands = listOf(
            MultiCommand(2),
            MultiCommand(2),
            MultiCommand(2),
            MultiCommand(2),
            MinusCommand(100),
            MultiCommand(-1)
        )

        var actual = 1
        commands.forEach { command ->
            actual = command.execute(actual)
        }

        Assertions.assertEquals(84, actual)
    }

    @Test
    fun test_3() {
        val commands = listOf(
            AddCommand(-1),
            MinusCommand(1000),
            MultiCommand(-2)
        )

        var actual = 1
        commands.forEach { command ->
            actual = command.execute(actual)
        }

        Assertions.assertEquals(2000, actual)
    }

}