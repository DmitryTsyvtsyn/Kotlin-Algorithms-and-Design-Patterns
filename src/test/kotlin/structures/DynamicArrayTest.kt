package structures

import org.junit.Test
import org.junit.Assert.assertEquals

internal class DynamicArrayTest {

    @Test
    fun test() {
        val array = DynamicArray<Int>()
        array.add(1)
        array.add(2)
        array.add(3)
        array.add(4)

        assertEquals("""
            capacity: 10
            size: 4
            elements: 1, 2, 3, 4
        """.trimIndent(), array.toString())

        assertEquals(1, array.set(0, 10))
        assertEquals(10, array.get(0))

        assertEquals(2, array.set(1, 20))
        assertEquals(20, array.get(1))

        assertEquals(3, array.set(2, 30))
        assertEquals(30, array.get(2))

        assertEquals(4, array.set(3, 40))
        assertEquals(40, array.get(3))

        assertEquals(true, array.remove(10))
        assertEquals(true, array.remove(20))
        assertEquals(true, array.remove(30))
        assertEquals(true, array.remove(40))

        array.add(1); array.add(2); array.add(3); array.add(4); array.add(5)
        array.add(6); array.add(7); array.add(8); array.add(9); array.add(10)
        array.add(11); array.add(12); array.add(13); array.add(14); array.add(15)

        assertEquals("""
            capacity: 20
            size: 15
            elements: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        """.trimIndent(), array.toString())
    }

}