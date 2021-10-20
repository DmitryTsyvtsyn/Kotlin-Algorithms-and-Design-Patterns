package sorting

import org.junit.Test

internal class InsertionSortTest : SortTest() {
    override val sort: SortAlgo<Int>
        get() = InsertionSort()

    @Test
    fun test() { test_all() }

}