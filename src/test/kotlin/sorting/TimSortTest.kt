package sorting

import org.junit.Test
import kotlin.random.Random
import org.junit.Assert.assertArrayEquals

class TimSortTest {

    @Test
    fun `test sort`() {
        val timSort = TimSort()

        val expected1 = Array(1_000_000) { it }
        val actual1 = expected1.reversedArray()
        timSort.sort(actual1)
        assertArrayEquals(expected1, actual1)

        val actual2 = Array(1_000_000) { Random.nextInt(1_000_000) }
        val expected2 = actual2.sortedArray()
        timSort.sort(actual2)
        assertArrayEquals(expected2, actual2)

        val expected3 = Array(1_000_000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        timSort.sort(actual3)
        assertArrayEquals(expected3, actual3)

        val expected4 = Array(1_000_000) { it }
        val actual4 = expected3.copyOf()
        timSort.sort(actual3)
        assertArrayEquals(expected4, actual4)
    }

}