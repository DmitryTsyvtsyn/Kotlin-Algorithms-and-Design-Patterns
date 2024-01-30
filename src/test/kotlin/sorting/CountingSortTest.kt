package sorting

import org.junit.Test
import org.junit.Assert.assertArrayEquals

class CountingSortTest {

    @Test
    fun test() {
        val countingSort = CountingSort()

        val actual1 = arrayOf(
            5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 4, 3, 4, 3, 3, 0,
            0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 5, 3, 2, 2, 1, 1, 0
        )
        val expected1 = actual1.sortedArray()
        countingSort.sort(actual1,0, 5)
        assertArrayEquals(expected1, actual1)

        val actual2 = arrayOf(9, 9, 9, 10, 10, 5, 4, 4, 4, 1, 1, 1, 3, 3, 3)
        val expected2 = actual2.sortedArray()
        countingSort.sort(actual2, 1, 10)
        assertArrayEquals(expected2, actual2)

        val actual3 = arrayOf(
            1000, 1000, 555, 555, 555, 333, 222, 222, 1, 1, 1, 222, 222, 555, 587, 587, 1, 587,
            1000, 1000, 1000, 6, 7, 6, 7, 7, 7, 6, 1, 1, 222, 555, 587, 3, 3, 3, 1, 3, 3, 6, 6,
            49, 587, 587, 49, 49, 49, 100, 100, 1000, 100, 1000, 555, 222
        )
        val expected3 = actual3.sortedArray()
        countingSort.sort(actual3, 1, 1000)
        assertArrayEquals(expected3, actual3)
    }

}