package search

import org.junit.Test

class BinarySearchTest : SearchTest() {

    override val searchAlgo: Search<Int>
        get() = BinarySearch()

    @Test
    fun test() { test_all() }
}