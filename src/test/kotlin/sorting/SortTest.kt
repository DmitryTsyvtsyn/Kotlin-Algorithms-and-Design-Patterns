package sorting

import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

abstract class SortTest {

    abstract val sort: SortAlgo<Int>

    fun test_all() {
        test_reversed_array()
        test_random_array()
        test_shuffled_array()
        test_sorted_array()
    }

    fun test_reversed_array() {
        val sortedArray = arrayOf(1, 20, 30, 40)
        val reversedArray = sortedArray.reversedArray()
        Assert.assertEquals(sort.sort(reversedArray).toList(), sortedArray.toList())
    }

    fun test_random_array() {
        val array = arrayOf(Random.nextInt(100), Random.nextInt(100), Random.nextInt(100), Random.nextInt(100))
        val sortedArray = array.sorted()
        Assert.assertEquals(sort.sort(array).toList(), sortedArray.toList())
    }


    fun test_shuffled_array() {
        val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val shuffledArray = sortedArray.copyOf()
        shuffledArray.shuffle()
        Assert.assertEquals(sort.sort(shuffledArray).toList(), sortedArray.toList())
    }

    fun test_sorted_array() {
        val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Assert.assertEquals(sort.sort(sortedArray).toList(), sortedArray.toList())
    }

}