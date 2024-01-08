package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class AdapterTest {

    @Test
    fun test() {
        // we don't understand EnglishSpeaker interface
        val englishSpeaker = EnglishSpeakerImpl()
        // but we know about SpainSpeaker interface
        val speakerAdapter = SpainSpeakerAdapter(englishSpeaker)

        // EnglishSpeaker interface was changed to SpainSpeaker interface
        val actual = speakerAdapter.speakSpanish()

        assertEquals("Hola, amigo!", actual)
    }

}