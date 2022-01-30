package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MonostateTest {

    @Test
    fun test() {

        val linearLayout = mutableListOf<TextView>()

        for (i in 1..10) {
            linearLayout.add(TextView())
        }

        assertEquals(10, linearLayout.first().textViewCount())

        linearLayout.forEach { txtView -> txtView.onDetachView() }

        assertEquals(0, linearLayout.first().textViewCount())
    }
}