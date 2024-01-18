package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class BridgeTest {

    @Test
    fun test() {
        val windowsSystem = WindowsSystem()
        val macOSSystem = MacOSSystem()

        // the line doesn't know how graphics are implemented in different operating systems
        val line = GraphicLinePrimitive(0, 0, 100, 100)
        line.draw(windowsSystem)
        line.draw(macOSSystem)

        // the circle doesn't know how graphics are implemented in different operating systems
        val circle = GraphicCirclePrimitive(10, 10, 6)
        circle.draw(windowsSystem)
        circle.draw(macOSSystem)

        assertEquals("""
            Windows 10
            Lines:
            Windows graphic subsystem -> startX: 0, startY: 0, endX: 100, endY: 100
            Circles:
            Windows graphic subsystem -> centerX: 10, centerY: 10, radius: 6
        """.trimIndent(), windowsSystem.toString())

        assertEquals("""
            MacOS 14
            Lines:
            MacOS graphic subsystem -> startX: 0, startY: 0, endX: 100, endY: 100
            Circles:
            MacOS graphic subsystem -> centerX: 10, centerY: 10, radius: 6
        """.trimIndent(), macOSSystem.toString())
    }

}