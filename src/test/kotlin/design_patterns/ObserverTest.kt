package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class ObserverTest {

    @Test
    fun test() {
        val ponyList = PonyList()
        ponyList.observe { items ->
            assertEquals("Twillight Sparkle", items.first())
        }
        ponyList.add("Twillight Sparkle")
    }

}