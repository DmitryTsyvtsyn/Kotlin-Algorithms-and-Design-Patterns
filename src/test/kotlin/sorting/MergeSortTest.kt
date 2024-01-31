package sorting

import org.junit.Test
import kotlin.random.Random
import org.junit.Assert.assertArrayEquals

class MergeSortTest {

    private val mergeSort = MergeSort()

    @Test
    fun `test sort`() {
        val expected1 = Array(1_000_000) { it }
        val actual1 = expected1.reversedArray()
        mergeSort.sort(actual1)
        assertArrayEquals(expected1, actual1)

        val actual2 = Array(1_000_000) { Random.nextInt(1_000_000) }
        val expected2 = actual2.sortedArray()
        mergeSort.sort(actual2)
        assertArrayEquals(expected2, actual2)

        val expected3 = Array(1_000_000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        mergeSort.sort(actual3)
        assertArrayEquals(expected3, actual3)

        val expected4 = Array(1_000_000) { it }
        val actual4 = expected3.copyOf()
        mergeSort.sort(actual3)
        assertArrayEquals(expected4, actual4)
    }

    @Test
    fun `test sort recursive`() {
        val expected1 = Array(1_000_000) { it }
        val actual1 = expected1.reversedArray()
        mergeSort.sortRecursive(actual1)
        assertArrayEquals(expected1, actual1)

        val actual2 = Array(1_000_000) { Random.nextInt(1_000_000) }
        val expected2 = actual2.sortedArray()
        mergeSort.sortRecursive(actual2)
        assertArrayEquals(expected2, actual2)

        val expected3 = Array(1_000_000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        mergeSort.sortRecursive(actual3)
        assertArrayEquals(expected3, actual3)

        val expected4 = Array(1_000_000) { it }
        val actual4 = expected3.copyOf()
        mergeSort.sortRecursive(actual3)
        assertArrayEquals(expected4, actual4)
    }

}