package other

import org.junit.Test
import junit.framework.TestCase.assertEquals

internal class ReverseArrayAlgorithmTest {

    private val reverseArrayAlgorithm = ReverseArrayAlgorithm()

    @Test
    fun `test numbers`() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        reverseArrayAlgorithm.compute(array)

        assertEquals(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), array.toList())
    }

    @Test
    fun `test strings`() {
        val array = arrayOf("Twillight Sparkle", "Pinky Pie", "Apple Jack", "Rainbow Dash", "Fluttershy", "Rarity")

        reverseArrayAlgorithm.compute(array)

        assertEquals(listOf("Rarity", "Fluttershy", "Rainbow Dash", "Apple Jack", "Pinky Pie", "Twillight Sparkle"), array.toList())
    }

}