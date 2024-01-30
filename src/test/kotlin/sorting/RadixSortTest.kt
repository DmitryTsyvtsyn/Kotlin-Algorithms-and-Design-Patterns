package sorting

import org.junit.Test
import org.junit.Assert.assertArrayEquals
import kotlin.random.Random

class RadixSortTest {

    @Test
    fun test() {
        val radixSort = RadixSort()

        val expected1 = Array(1_000_000) { it }
        val actual1 = expected1.reversedArray()
        radixSort.sort(actual1)
        assertArrayEquals(expected1, actual1)

        val actual2 = Array(1_000_000) { Random.nextInt(1_000_000) }
        val expected2 = actual2.sortedArray()
        radixSort.sort(actual2)
        assertArrayEquals(expected2, actual2)

        val expected3 = Array(1_000_000) { it }
        val actual3 = expected3.copyOf()
        actual3.shuffle()
        radixSort.sort(actual3)
        assertArrayEquals(expected3, actual3)

        val expected4 = Array(1_000_000) { it }
        val actual4 = expected3.copyOf()
        radixSort.sort(actual3)
        assertArrayEquals(expected4, actual4)
    }

}