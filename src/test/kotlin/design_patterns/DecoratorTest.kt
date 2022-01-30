package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions

class DecoratorTest {
    @Test
    fun test() {
        val printer = ExclamationPrinter(
            WorldPrinter(
                SpacePrinter(
                    CommaPrinter(
                        HelloPrinter()
                    )
                )
            )
        )
        Assertions.assertEquals("Hello, World!", printer.printedText())
    }
}