package sorting

import org.junit.Test
import org.junit.Assert.assertArrayEquals
import kotlin.random.Random

internal class InsertionSortTest {

    @Test
    fun `test sort`() {
        val insertionSort = InsertionSort()

        val expected1 = Array(1000) { it }
        val actual1 = expected1.reversedArray()
        insertionSort.sort(actual1)
        assertArrayEquals(expected1, actual1)

        val actual2 = Array(1000) { Random.nextInt(1000) }
        val expected2 = actual2.sortedArray()
        insertionSort.sort(actual2)
        assertArrayEquals(expected2, actual2)

        val expected3 = Array(1000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        insertionSort.sort(actual3)
        assertArrayEquals(expected3, actual3)

        val expected4 = Array(1000) { it }
        val actual4 = expected3.copyOf()
        insertionSort.sort(actual3)
        assertArrayEquals(expected4, actual4)
    }

}