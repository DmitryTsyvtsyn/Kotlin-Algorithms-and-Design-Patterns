package search

import org.junit.Test

internal class BinarySearchRecursiveTest : SearchTest() {
    override val searchAlgo: Search<Int>
        get() = BinarySearchRecursive()

    @Test
    fun test() { test_all() }
}