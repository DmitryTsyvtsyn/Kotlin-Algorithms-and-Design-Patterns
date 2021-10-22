package search

import org.junit.Test

class LinearSearchTest : SearchTest() {

    override val searchAlgo: Search<Int>
        get() = LinearSearch()

    @Test
    fun test() { test_all() }
}