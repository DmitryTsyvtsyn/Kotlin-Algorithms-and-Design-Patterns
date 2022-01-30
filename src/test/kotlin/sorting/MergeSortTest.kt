package sorting

import org.junit.Test
import org.junit.jupiter.api.Assertions
import kotlin.random.Random

class MergeSortTest {

    private val sort = MergeSort()

    @Test
    fun test_reversed_array() {
        val sortedArray = arrayOf(1, 20, 30, 40)
        val reversedArray = sortedArray.reversedArray()
        Assertions.assertEquals(sort.sort(reversedArray).toList(), sortedArray.toList())
    }

    @Test
    fun test_random_array() {
        val array = arrayOf(Random.nextInt(100), Random.nextInt(100), Random.nextInt(100), Random.nextInt(100))
        val sortedArray = array.sorted()
        Assertions.assertEquals(sort.sort(array).toList(), sortedArray.toList())
    }

    @Test
    fun test_shuffled_array() {
        val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val shuffledArray = sortedArray.copyOf()
        shuffledArray.shuffle()
        Assertions.assertEquals(sort.sort(shuffledArray).toList(), sortedArray.toList())
    }

    @Test
    fun test_sorted_array() {
        val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Assertions.assertEquals(sort.sort(sortedArray).toList(), sortedArray.toList())
    }


}