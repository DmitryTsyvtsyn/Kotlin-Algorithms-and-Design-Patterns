package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FactoryTest {

    @Test
    fun test() {
        val factory = ScreenFactory()

        val fullHdScreen = factory.screenBy(Screens.FULL_HD)
        val fullHdSize = fullHdScreen.size()

        assertEquals(1920f, fullHdSize.first)
        assertEquals(1080f, fullHdSize.second)

        val hdScreen = factory.screenBy(Screens.HD)
        val hdSize = hdScreen.size()

        assertEquals(1280f, hdSize.first)
        assertEquals(720f, hdSize.second)
    }
}