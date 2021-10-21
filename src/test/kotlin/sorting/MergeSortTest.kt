package sorting

import org.junit.Test

class MergeSortTest : SortTest() {

    override val sort: SortAlgo<Int>
        get() = MergeSort()

    @Test
    fun test() { test_all() }
}