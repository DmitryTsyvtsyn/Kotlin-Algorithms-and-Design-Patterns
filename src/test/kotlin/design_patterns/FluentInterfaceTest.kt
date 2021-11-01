package design_patterns

import design_patterns.helpers.ViewContext
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FluentInterfaceTest {

    @Test
    fun test() {

        val view = View(ViewContext()).changeBackground(0xffffff)
            .makeFocusable()
            .makeClickable()

        view.draw()

        assertEquals(0xffffff, view.bgColor())
        assertEquals(true, view.clickable())
        assertEquals(true, view.focusable())
    }

}