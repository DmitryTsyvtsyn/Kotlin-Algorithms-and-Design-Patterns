package design_patterns

/**
 *
 * Proxy is a structural design pattern that provides an object
 *
 * that controls access to another object by intercepting all calls.
 *
 * There are several types of this pattern:
 *
 * 1) Logging proxy - saves all calls to a real object with their parameters to the log (shown in this example)
 * 2) Remote proxy - provides communication with an object which is located in a different address space or on a remote machine (Java Remote Procedure Call)
 * 3) Virtual proxy - ensures that a real object is created only when it is actually needed (shown in this example)
 * 4) Protection proxy - checks whether the caller has the necessary rights to execute the request
 * 5) Caching proxy - provides temporary storage of calculation results
 * 6) Synchronizing proxy - performs synchronized access control to an object in a multi-threaded environment (Collections.synchronized** methods)
 * 7) Smart reference proxy - performs additional actions when a link is created to an object
 *
 */

interface AudioPlayer {
    val currentState: String

    fun play(audio: String)
    fun pause()
    fun resume()
    fun stop()
}

// we have the simple player simulation
class AudioPlayerImpl : AudioPlayer {

    private var currentAudio: String = ""
    private var currentStatus = MediaPlayerStatus.NOT_INITIALIZED

    override val currentState: String
        get() = """
            current audio: $currentAudio
            current status: $currentStatus
        """.trimIndent()

    override fun play(audio: String) {
        if (audio.isNotBlank()) {
            currentAudio = audio
            currentStatus = MediaPlayerStatus.RUNNING
        }
    }
    override fun pause() {
        if (currentStatus == MediaPlayerStatus.RUNNING) {
            currentStatus = MediaPlayerStatus.PAUSED
        }
    }

    override fun resume() {
        if (currentStatus == MediaPlayerStatus.PAUSED) {
            currentStatus = MediaPlayerStatus.RUNNING
        }
    }

    override fun stop() {
        if (currentStatus != MediaPlayerStatus.NOT_INITIALIZED) {
            currentAudio = ""
            currentStatus = MediaPlayerStatus.NOT_INITIALIZED
        }
    }

    enum class MediaPlayerStatus {
        NOT_INITIALIZED, PAUSED, RUNNING
    }

}

// MediaPlayerProxy defers the creation of a real object (virtual proxy) and logs all its calls (logging proxy)
class AudioPlayerProxy : AudioPlayer {

    // deferred creation of the real player
    private val player: AudioPlayer by lazy { AudioPlayerImpl() }

    override val currentState: String
        get() = player.currentState

    override fun play(audio: String) {
        player.play(audio)
        // logs real player calls
        println("play audio: $audio")
    }

    override fun pause() {
        player.pause()
        println("pause")
    }

    override fun resume() {
        player.resume()
        println("resume")
    }

    override fun stop() {
        player.stop()
        println("stop")
    }

}