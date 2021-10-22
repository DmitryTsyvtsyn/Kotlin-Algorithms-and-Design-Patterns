package search

import org.junit.Assert.assertEquals

abstract class SearchTest {

    abstract val searchAlgo: Search<Int>

    protected fun test_all() {
        test_existed_element()
        test_none_existed_element()
    }

    private fun test_existed_element() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(true, searchAlgo.exists(array, 4))
    }

    private fun test_none_existed_element() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(false, searchAlgo.exists(array, 100))
    }

}