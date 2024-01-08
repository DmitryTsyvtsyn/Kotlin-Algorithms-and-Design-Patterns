package design_patterns

/**
 *
 * Adapter is a structural design pattern that allows objects with incompatible interfaces to work together
 *
 */

interface EnglishSpeaker {
    fun speakEnglish(): String
}

class EnglishSpeakerImpl : EnglishSpeaker {
    override fun speakEnglish(): String {
        return "Hello, friend!"
    }
}

interface SpainSpeaker {
    fun speakSpanish(): String
}

class SpainSpeakerAdapter(private val englishSpeaker: EnglishSpeaker) : SpainSpeaker {

    override fun speakSpanish(): String =
        when (englishSpeaker.speakEnglish()) {
            "Hello, friend!" -> "Hola, amigo!"
            else -> "No te entiendo"
        }

}