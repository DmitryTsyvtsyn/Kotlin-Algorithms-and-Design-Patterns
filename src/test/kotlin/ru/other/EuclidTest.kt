package ru.other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class EuclidTest {

    private val euclid = Euclid()

    @Test
    fun test_one() {
        assertEquals(5, euclid.compute(10, 5))
        assertEquals(10, euclid.compute(10, 100))
        assertEquals(9, euclid.compute(9, 27))
        assertEquals(13, euclid.compute(26, 39))
    }

    @Test
    fun test_two() {
        assertEquals(1, euclid.compute(135, 13))
        assertEquals(1, euclid.compute(27, 19))
        assertEquals(1, euclid.compute(2, 17))
        assertEquals(1, euclid.compute(4, 9))
    }

}