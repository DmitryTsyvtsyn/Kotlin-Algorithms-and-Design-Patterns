package sorting

import org.junit.Test

class RadixSortTest : SortTest() {

    override val sort: SortAlgo<Int>
        get() = RadixSort()

    @Test
    fun test() { test_all() }
}