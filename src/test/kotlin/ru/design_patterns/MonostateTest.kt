package ru.design_patterns

import ru.design_patterns.helpers.ViewContext
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MonostateTest {

    @Test
    fun test() {

        val linearLayout = mutableListOf<TextView>()

        for (i in 1..10) {
            linearLayout.add(TextView(ViewContext()))
        }

        assertEquals(10, linearLayout.first().textViewCount())

        linearLayout.forEach { txtView -> txtView.onDetachView() }

        assertEquals(0, linearLayout.first().textViewCount())
    }
}