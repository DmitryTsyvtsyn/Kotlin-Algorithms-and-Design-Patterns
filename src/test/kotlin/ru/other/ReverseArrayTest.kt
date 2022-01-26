package ru.other

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ReverseArrayTest {

    @Test
    fun test_numbers() {
        val reverseArray = ReverseArray<Int>()
        val actual = reverseArray.compute(arrayOf(1, 2, 3)).toList()
        val expected = arrayOf(3, 2, 1).toList()
        assertEquals(expected, actual)
    }

    @Test
    fun test_strings() {
        val reverseArray = ReverseArray<String>()
        val actual = reverseArray.compute(arrayOf("Twillight Sparkle", "Pinky Pie", "Apple Jack")).toList()
        val expected = arrayOf("Apple Jack", "Pinky Pie", "Twillight Sparkle").toList()
        assertEquals(expected, actual)
    }
}