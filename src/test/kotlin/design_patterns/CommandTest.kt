package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class CommandTest {

    @Test
    fun `test 1`() {
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

        assertEquals(50, actual)
    }

    @Test
    fun `test 2`() {
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

        assertEquals(84, actual)
    }

    @Test
    fun `test 3`() {
        val commands = listOf(
            AddCommand(-1),
            MinusCommand(1000),
            MultiCommand(-2)
        )

        var actual = 1
        commands.forEach { command ->
            actual = command.execute(actual)
        }

        assertEquals(2000, actual)
    }

    @Test
    fun `test MacroCommand`() {
        val command = MacroCommand(
            MultiCommand(2),
            AddCommand(10),
            MinusCommand(100)
        )

        assertEquals(-70, command.execute(10))
    }

    @Test
    fun `test Kotlin variant`() {
        val commands: List<(Int) -> Int> = listOf(
            { actual: Int -> actual + 49 },
            { actual: Int -> actual - 20 },
            { actual: Int -> actual * 6 }
        )

        var actual = 1
        commands.forEach { command ->
            actual = command.invoke(actual)
        }

        assertEquals(180, actual)
    }

}