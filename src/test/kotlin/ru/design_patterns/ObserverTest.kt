package ru.design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class ObserverTest {
    @Test
    fun test() {
        val ponyList = PonyList()
        ponyList.observe { items ->
            assertEquals("Twillight Sparkle", items.first())
        }
        ponyList.add("Twillight Sparkle")
    }
}