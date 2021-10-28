package search

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class BinarySearchRecursiveTest : SearchTest() {
    override val searchAlgo: Search<Int>
        get() = BinarySearchRecursive()

    @Test
    fun test() { test_all() }
}