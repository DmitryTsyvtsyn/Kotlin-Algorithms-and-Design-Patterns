package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class PrototypeTest {

    @Test
    fun test() {
        // we have a list of sweets that need to be made at the confectionery factory
        val recipesOfSweets = listOf(
            OreoCookies("Original OREO", "Rich chocolate cookies with vanilla creme", 12),
            OreoCookies("Golden OREO", "Sweet vanilla cookies with vanilla creme", 13),
            OreoCookies("OREO Thins", "Sweet vanilla cookies with vanilla creme", 11),
            `M&MsChocolate`("with puffed rice", 10),
            `M&MsChocolate`("with peanuts", 11)
        )

        // we produce sweets according to existing recipes
        val producedSweets = recipesOfSweets.flatMap { sweets -> List(10) { sweets.copy() } }

        assertEquals(producedSweets.size, 50)
        assertEquals(producedSweets[9], recipesOfSweets[0])
        assertEquals(producedSweets[19], recipesOfSweets[1])
        assertEquals(producedSweets[29], recipesOfSweets[2])
        assertEquals(producedSweets[39], recipesOfSweets[3])
        assertEquals(producedSweets[49], recipesOfSweets[4])
    }

}