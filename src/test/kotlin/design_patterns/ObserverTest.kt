package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class ObserverTest {

    @Test
    fun test() {
        val ponyList = PonyList()

        val observer1 = PonyObserver { items ->
            assertEquals(listOf("Twillight Sparkle"), items)
        }
        ponyList.addObserver(observer1)
        // we add the first item, observer1 is triggered
        ponyList.add("Twillight Sparkle")
        // we remove observer1 so that it is not called again
        ponyList.removeObserver(observer1)

        val observer2 = PonyObserver { items ->
            assertEquals(listOf("Twillight Sparkle", "Starlight Glimmer"), items)
        }
        ponyList.addObserver(observer2)
        // we add the second item, observer2 is triggered
        ponyList.add("Starlight Glimmer")
    }

}