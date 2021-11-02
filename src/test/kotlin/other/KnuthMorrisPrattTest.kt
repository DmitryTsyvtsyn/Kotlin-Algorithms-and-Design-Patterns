package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class KnuthMorrisPrattTest {

    @Test
    fun test() {
        val knuthMorrisPratt = KnuthMorrisPratt()

        assertEquals(true, knuthMorrisPratt.contains("twilly", "twilly likes reading books!"))
        assertEquals(false, knuthMorrisPratt.contains("I", "you are so beautiful!"))

        assertEquals(3, knuthMorrisPratt.count("the", "Watch the Keynote, livestream replay, and tech talks to hear about the latest updates in Android development directly from the Android team."))
        assertEquals(0, knuthMorrisPratt.count("Kotlin", "Watch the Keynote, livestream replay, and tech talks to hear about the latest updates in Android development directly from the Android team."))
    }

}