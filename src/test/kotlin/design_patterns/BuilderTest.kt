package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class BuilderTest {

    @Test
    fun test_first_variant() {
        val dnsServerAddress = "8.8.8.8"
        val callTimeout = 500
        val connectTimeout = 3_000
        val writeTimeout = 3_000
        val readTimeout = 3_000

        val httpClient = HttpConnectionClient1.Builder()
            .dnsServerAddress(dnsServerAddress)
            .callTimeout(callTimeout)
            .connectTimeout(connectTimeout)
            .writeTimeout(writeTimeout)
            .readTimeout(readTimeout)
            .build()

        val expected = """
            dns -> $dnsServerAddress
            call timeout -> $callTimeout
            connect timeout -> $connectTimeout
            read timeout -> $readTimeout
            write timeout -> $writeTimeout
        """.trimIndent()

        assertEquals(expected, httpClient.toString())
    }

    @Test
    fun test_the_second_variant() {
        val dnsServerAddress = "8.8.8.8"
        val callTimeout = 500
        val connectTimeout = 3_000
        val writeTimeout = 3_000
        val readTimeout = 3_000

        val httpClient = HttpConnectionClient2.newBuilder()
            .dnsServerAddress(dnsServerAddress)
            .callTimeout(callTimeout)
            .connectTimeout(connectTimeout)
            .writeTimeout(writeTimeout)
            .readTimeout(readTimeout)
            .build()

        val expected = """
            dns -> $dnsServerAddress
            call timeout -> $callTimeout
            connect timeout -> $connectTimeout
            read timeout -> $readTimeout
            write timeout -> $writeTimeout
        """.trimIndent()

        assertEquals(expected, httpClient.toString())
    }

    @Test
    fun test_third_variant() {
        val dnsServerAddress = "8.8.8.8"
        val callTimeout = 500
        val connectTimeout = 3_000
        val writeTimeout = 3_000
        val readTimeout = 3_000

        val httpClient = HttpConnectionClient3(
            dnsServerAddress = dnsServerAddress,
            callTimeout = callTimeout,
            connectTimeout = connectTimeout,
            readTimeout = readTimeout,
            writeTimeout = writeTimeout
        )

        val expected = """
            dns -> $dnsServerAddress
            call timeout -> $callTimeout
            connect timeout -> $connectTimeout
            read timeout -> $readTimeout
            write timeout -> $writeTimeout
        """.trimIndent()

        assertEquals(expected, httpClient.toString())
    }

}