package ru.other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class FactorialTest {

    private val factorial = Factorial()

    @Test
    fun test_iterative() {
        assertEquals(6, factorial.compute(3))
        assertEquals(120, factorial.compute(5))
        assertEquals(720, factorial.compute(6))
    }

    @Test
    fun test_recursive() {
        assertEquals(6, factorial.computeRecursive(3))
        assertEquals(120, factorial.computeRecursive(5))
        assertEquals(720, factorial.computeRecursive(6))
    }

}