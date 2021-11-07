package other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FizzBuzzTest {

    private val fizzBuzz = FizzBuzz()

    @Test
    fun test_fizz() {
        val actual = fizzBuzz.compute(3)
        val expected = "Fizz"
        assertEquals(expected, actual)
    }

    @Test
    fun test_buzz() {
        val actual = fizzBuzz.compute(5)
        val expected = "Buzz"
        assertEquals(expected, actual)
    }

    @Test
    fun test_fizz_buzz() {
        val actual = fizzBuzz.compute(15)
        val expected = "FizzBuzz"
        assertEquals(expected, actual)
    }

    @Test
    fun test_no_fizz_buzz() {
        val actual = fizzBuzz.compute(1)
        val expected = "1"
        assertEquals(expected, actual)
    }
}