package sorting

import org.junit.Test
import org.junit.Assert.assertEquals

class QuickSortTest {

    @Test
    fun test_reversed_array() {
        val expected = TestUtils.list(1_000_000)

        val actual = expected.reversed().toTypedArray()
        actual.quickSort()

        assertEquals(expected, actual.toList())
    }

    @Test
    fun test_random_array() {
        val actual = TestUtils.randomArray(5_000_000)

        val expected = actual.sorted()

        actual.quickSort()

        assertEquals(expected, actual.toList())
    }

    @Test
    fun test_shuffled_array() {
        val expected = TestUtils.sortedArray(1_000_000)

        val actual = expected.copyOf()
        actual.shuffle()
        actual.quickSort()

        assertEquals(expected.toList(), actual.toList())
    }

    @Test
    fun test_sorted_array() {
        val actual = TestUtils.sortedArray(1_000_000)

        val expected = actual.toList()

        actual.quickSort()

        assertEquals(expected, actual.toList())
    }

    @Test
    fun test_random_list() {
        val actual = TestUtils.mutableRandomList(1_000_000)

        val expected = actual.sorted()

        actual.quickSort()

        assertEquals(expected, actual)
    }

}