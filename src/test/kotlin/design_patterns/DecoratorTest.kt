package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

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
        assertEquals("Hello, World!", printer.printedText())
    }

}