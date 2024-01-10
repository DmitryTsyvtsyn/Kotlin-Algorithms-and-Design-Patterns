package design_patterns

/**
 *
 * Builder is is a generative design pattern that is used to create complex objects,
 *
 * separates the construction of an object from its representation
 *
 */

/**
 * The first variant
 */
class HttpConnectionClient1 private constructor(
    private val dnsServerAddress: String,
    private val callTimeout: Int,
    private val connectTimeout: Int,
    private val readTimeout: Int,
    private val writeTimeout: Int,
    // class can have many more fields
) {

    override fun toString() = """
        dns -> $dnsServerAddress
        call timeout -> $callTimeout
        connect timeout -> $connectTimeout
        read timeout -> $readTimeout
        write timeout -> $writeTimeout
    """.trimIndent()

    class Builder {
        private var dnsServerAddress: String = "8.8.8.8"
        private var callTimeout: Int = 0
        private var connectTimeout: Int = 10_000
        private var readTimeout: Int = 10_000
        private var writeTimeout: Int = 0

        fun dnsServerAddress(address: String) = apply {
            dnsServerAddress = address
        }

        fun callTimeout(timeout: Int) = apply {
            // we can add some checks such as:
            // if (timeout < 0) throw IllegalArgumentException("Uncorrected timeout: $timeout")
            callTimeout = timeout
        }

        fun connectTimeout(timeout: Int) = apply {
            connectTimeout = timeout
        }

        fun readTimeout(timeout: Int) = apply {
            readTimeout = timeout
        }

        fun writeTimeout(timeout: Int) = apply {
            writeTimeout = timeout
        }

        fun build() = HttpConnectionClient1(dnsServerAddress, callTimeout, connectTimeout, readTimeout, writeTimeout)

    }

}

/**
 * The second variant
 */
class HttpConnectionClient2 private constructor() {
    private var dnsServerAddress: String = "8.8.8.8"
    private var callTimeout: Int = 0
    private var connectTimeout: Int = 10_000
    private var readTimeout: Int = 10_000
    private var writeTimeout: Int = 0

    override fun toString() = """
        dns -> $dnsServerAddress
        call timeout -> $callTimeout
        connect timeout -> $connectTimeout
        read timeout -> $readTimeout
        write timeout -> $writeTimeout
    """.trimIndent()

    companion object {
        fun newBuilder() = HttpConnectionClient2().Builder()
    }

    inner class Builder {

        fun dnsServerAddress(address: String) = apply {
            dnsServerAddress = address
        }

        fun callTimeout(timeout: Int) = apply {
            // we can add some checks such as:
            // if (timeout < 0) throw IllegalArgumentException("Uncorrected timeout: $timeout")
            callTimeout = timeout
        }

        fun connectTimeout(timeout: Int) = apply {
            connectTimeout = timeout
        }

        fun readTimeout(timeout: Int) = apply {
            readTimeout = timeout
        }

        fun writeTimeout(timeout: Int) = apply {
            writeTimeout = timeout
        }

        fun build() = this@HttpConnectionClient2
    }

}

/**
 * Kotlin variant with default arguments
 */
class HttpConnectionClient3(
    private val dnsServerAddress: String = "8.8.8.8",
    private val callTimeout: Int = 0,
    private val connectTimeout: Int = 10_000,
    private val readTimeout: Int = 10_000,
    private val writeTimeout: Int = 0
) {
    override fun toString() = """
        dns -> $dnsServerAddress
        call timeout -> $callTimeout
        connect timeout -> $connectTimeout
        read timeout -> $readTimeout
        write timeout -> $writeTimeout
    """.trimIndent()
}