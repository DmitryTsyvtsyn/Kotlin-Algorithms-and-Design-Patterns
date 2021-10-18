package sorting

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

internal class BubbleSortTest {

    private val bubbleSort = BubbleSort<Int>()

    @Test
    fun test_reversed_array() {
        val sortedArray = arrayOf(1, 20, 30, 40)
        val reversedArray = sortedArray.reversedArray()
        assertEquals(bubbleSort.sort(reversedArray).toList(), sortedArray.toList())
    }

    @Test
    fun test_random_array() {
        val array = arrayOf(Random.nextInt(100), Random.nextInt(100), Random.nextInt(100), Random.nextInt(100))
        val sortedArray = array.sorted()
        assertEquals(bubbleSort.sort(array).toList(), sortedArray.toList())
    }

    @Test
    fun test_shuffled_array() {
        val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val shuffledArray = sortedArray.copyOf()
        shuffledArray.shuffle()
        assertEquals(bubbleSort.sort(shuffledArray).toList(), sortedArray.toList())
    }
}