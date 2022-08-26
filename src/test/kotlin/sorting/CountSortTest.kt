package sorting

import org.junit.Test
import org.junit.jupiter.api.Assertions

class CountSortTest {

    @Test
    fun test_numbers_from_zero_to_five() {
        val numbers = arrayOf(5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 4, 3, 4, 3, 3, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 5, 3, 2, 2, 1, 1, 0)
        val expected = numbers.sorted()

        numbers.countSort(0, 5)

        Assertions.assertEquals(expected, numbers.toList())
    }

    @Test
    fun test_numbers_from_one_to_ten() {
        val numbers = arrayOf(9, 9, 9, 10, 10, 5, 4, 4, 4, 1, 1, 1, 3, 3, 3)
        val expected = numbers.sorted()

        numbers.countSort(1, 10)

        Assertions.assertEquals(expected, numbers.toList())
    }

    @Test
    fun test_numbers_from_one_to_thousand() {
        val numbers = arrayOf(1000, 1000, 555, 555, 555, 333, 222, 222, 1, 1, 1, 222, 222, 555, 587, 587, 1, 587, 1000, 1000, 1000, 6, 7, 6, 7, 7, 7, 6, 1, 1, 222, 555, 587, 3, 3, 3, 1, 3, 3, 6, 6, 49, 587, 587, 49, 49, 49, 100, 100, 1000, 100, 1000, 555, 222)
        val expected = numbers.sorted()

        numbers.countSort(1, 1000)

        Assertions.assertEquals(expected, numbers.toList())
    }

}