package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class KnuthMorrisPrattAlgorithmTest {

    @Test
    fun test() {
        val knuthMorrisPrattAlgorithm = KnuthMorrisPrattAlgorithm()

        val sentence1 = "Twillight Sparkle likes reading books!"
        assertEquals(true, knuthMorrisPrattAlgorithm.contains("Twillight Sparkle", sentence1))
        assertEquals(true, knuthMorrisPrattAlgorithm.contains("likes", sentence1))
        assertEquals(true, knuthMorrisPrattAlgorithm.contains("reading", sentence1))
        assertEquals(true, knuthMorrisPrattAlgorithm.contains("books", sentence1))

        assertEquals(false, knuthMorrisPrattAlgorithm.contains("Apple Jack", sentence1))
        assertEquals(false, knuthMorrisPrattAlgorithm.contains("loves", sentence1))
        assertEquals(false, knuthMorrisPrattAlgorithm.contains("learning", sentence1))
        assertEquals(false, knuthMorrisPrattAlgorithm.contains("articles", sentence1))

        val sentence2 = """
            Watch the Keynote, livestream replay, and tech talks to hear about the latest updates 
            in Android development directly from the Android team.
        """.trimIndent()
        assertEquals(3, knuthMorrisPrattAlgorithm.count("the", sentence2))
        assertEquals(2, knuthMorrisPrattAlgorithm.count("Android", sentence2))
        assertEquals(1, knuthMorrisPrattAlgorithm.count("and", sentence2))
        assertEquals(1, knuthMorrisPrattAlgorithm.count("Keynote", sentence2))

        assertEquals(0, knuthMorrisPrattAlgorithm.count("Kotlin", sentence2))
        assertEquals(0, knuthMorrisPrattAlgorithm.count("Jetpack Compose", sentence2))
        assertEquals(0, knuthMorrisPrattAlgorithm.count("Android Studio", sentence2))
        assertEquals(0, knuthMorrisPrattAlgorithm.count("developers", sentence2))
    }

}