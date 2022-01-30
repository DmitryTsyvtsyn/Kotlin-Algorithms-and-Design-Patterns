package sorting

import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class BubbleSortTest {

    @Test
    fun test_reversed_array() {
        val expected = TestUtils.list(1000)

        val actual = expected.reversed().toTypedArray()
        actual.bubbleSort()

        Assertions.assertEquals(expected, actual.toList())
    }

    @Test
    fun test_random_array() {
        val actual = TestUtils.randomArray(500)

        val expected = actual.sorted()

        actual.bubbleSort()

        Assertions.assertEquals(expected, actual.toList())
    }

    @Test
    fun test_shuffled_array() {
        val expected = TestUtils.sortedArray(1000)

        val actual = expected.copyOf()
        actual.shuffle()
        actual.bubbleSort()

        Assertions.assertEquals(expected.toList(), actual.toList())
    }

    @Test
    fun test_sorted_array() {
        val actual = TestUtils.sortedArray(1000)

        val expected = actual.toList()

        actual.bubbleSort()

        Assertions.assertEquals(expected, actual.toList())
    }

    @Test
    fun test_random_list() {
        val actual = TestUtils.mutableRandomList(5000)

        val expected = actual.sorted()

        actual.bubbleSort()

        Assertions.assertEquals(expected, actual)
    }


}