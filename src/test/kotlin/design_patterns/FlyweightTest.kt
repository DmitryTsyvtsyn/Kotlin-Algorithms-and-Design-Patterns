package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class FlyweightTest {

    @Test
    fun test() {
        val garden = BeautifulGarden()

        garden.placeTree("oak", "", 21, 10, 10)
        garden.placeTree("birch", "", 15, 10, 20)
        garden.placeTree("birch", "", 16, 10, 30)
        garden.placeTree("birch", "", 17, 10, 40)
        garden.placeTree("oak", "", 21, 20, 10)
        garden.placeTree("oak", "", 21, 20, 20)
        garden.placeTree("oak", "", 21, 20, 30)
        garden.placeTree("birch", "", 15, 20, 40)

        assertEquals("""
            Beautiful Garden:
            name: oak, height: 21, x: 10, y: 10
            name: birch, height: 15, x: 10, y: 20
            name: birch, height: 16, x: 10, y: 30
            name: birch, height: 17, x: 10, y: 40
            name: oak, height: 21, x: 20, y: 10
            name: oak, height: 21, x: 20, y: 20
            name: oak, height: 21, x: 20, y: 30
            name: birch, height: 15, x: 20, y: 40
            -|-|-|-|-|-|-|-|-|-|-
        """.trimIndent(), garden.placedTreesAsString())
    }

}