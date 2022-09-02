package other

import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class BinaryDigitsCounterTest {

    private val counter = BinaryDigitsCounter()

    @Test
    fun test_empty_string() {
        val result = counter.compute("")

        Assertions.assertEquals(BinaryDigitsCounter.Result(), result)
    }

    @Test
    fun test_binary_string_1() {
        val result = counter.compute("10101111000")

        Assertions.assertEquals(BinaryDigitsCounter.Result(6, 5), result)
    }

    @Test
    fun test_binary_string_2() {
        val result = counter.compute("0100000111110010101010")

        Assertions.assertEquals(BinaryDigitsCounter.Result(10, 12), result)
    }

    @Test
    fun test_binary_string_3() {
        val result = counter.compute("1111111111")

        Assertions.assertEquals(BinaryDigitsCounter.Result(10, 0), result)
    }

    @Test
    fun test_binary_string_4() {
        val result = counter.compute("0000000000")

        Assertions.assertEquals(BinaryDigitsCounter.Result(0, 10), result)
    }

}