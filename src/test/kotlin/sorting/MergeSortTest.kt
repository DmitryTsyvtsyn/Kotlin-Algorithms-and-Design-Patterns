package sorting

import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class MergeSortTest {

    private val mergeSort = MergeSort()

    @Test
    fun `test sort`() {
        val expected1 = Array(1_000_000) { it }
        val actual1 = expected1.reversedArray()
        mergeSort.sort(actual1)
        Assert.assertArrayEquals(expected1, actual1)

        val actual2 = Array(1_000_000) { Random.nextInt(1_000_000) }
        val expected2 = actual2.sortedArray()
        mergeSort.sort(actual2)
        Assert.assertArrayEquals(expected2, actual2)

        val expected3 = Array(1_000_000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        mergeSort.sort(actual3)
        Assert.assertArrayEquals(expected3, actual3)

        val expected4 = Array(1_000_000) { it }
        val actual4 = expected3.copyOf()
        mergeSort.sort(actual3)
        Assert.assertArrayEquals(expected4, actual4)
    }

    @Test
    fun `test sort recursive`() {
        val expected1 = Array(1_000_000) { it }
        val actual1 = expected1.reversedArray()
        mergeSort.sortRecursive(actual1)
        Assert.assertArrayEquals(expected1, actual1)

        val actual2 = Array(1_000_000) { Random.nextInt(1_000_000) }
        val expected2 = actual2.sortedArray()
        mergeSort.sortRecursive(actual2)
        Assert.assertArrayEquals(expected2, actual2)

        val expected3 = Array(1_000_000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        mergeSort.sortRecursive(actual3)
        Assert.assertArrayEquals(expected3, actual3)

        val expected4 = Array(1_000_000) { it }
        val actual4 = expected3.copyOf()
        mergeSort.sortRecursive(actual3)
        Assert.assertArrayEquals(expected4, actual4)
    }

}