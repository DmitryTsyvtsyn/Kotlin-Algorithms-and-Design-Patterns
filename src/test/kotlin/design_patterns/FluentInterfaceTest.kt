package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FluentInterfaceTest {

    @Test
    fun test() {

        val view = View().bg(0xffffff).focusable().clickable()

        view.draw()

        assertEquals(0xffffff, view.bgColor())
        assertEquals(true, view.isClickable())
        assertEquals(true, view.hasFocus())
    }

}