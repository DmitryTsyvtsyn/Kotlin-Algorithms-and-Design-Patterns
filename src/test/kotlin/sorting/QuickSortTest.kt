package sorting

import org.junit.Test

class QuickSortTest : SortTest() {

    override val sort: SortAlgo<Int>
        get() = QuickSort()

    @Test
    fun test() { test_all() }
}