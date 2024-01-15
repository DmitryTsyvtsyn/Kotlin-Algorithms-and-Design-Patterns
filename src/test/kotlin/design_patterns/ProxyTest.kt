package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class ProxyTest {

    @Test
    fun test() {
        // we use the proxy object instead of a real one
        val mediaPlayer = AudioPlayerProxy()

        mediaPlayer.play("track_0.mp3")
        assertEquals("""
            current audio: track_0.mp3
            current status: RUNNING
        """.trimIndent(), mediaPlayer.currentState)

        mediaPlayer.pause()
        assertEquals("""
            current audio: track_0.mp3
            current status: PAUSED
        """.trimIndent(), mediaPlayer.currentState)

        mediaPlayer.resume()
        assertEquals("""
            current audio: track_0.mp3
            current status: RUNNING
        """.trimIndent(), mediaPlayer.currentState)

        mediaPlayer.stop()
        assertEquals("""
            current audio: 
            current status: NOT_INITIALIZED
        """.trimIndent(), mediaPlayer.currentState)
    }

}