package sorting

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class SelectionSortTest : SortTest() {

    override val sort: SortAlgo<Int>
        get() = SelectionSort()

    @Test
    fun test() { test_all() }
}