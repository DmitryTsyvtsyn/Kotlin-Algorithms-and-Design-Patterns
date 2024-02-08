package structures

import org.junit.Test
import org.junit.Assert.assertEquals

internal class SingleLinkedListTest {

    @Test
    fun `test is empty`() {
        val list = SingleLinkedList<Int>()

        assertEquals(true, list.isEmpty)

        list.add(1)
        list.add(2)
        list.add(3)

        assertEquals(false, list.isEmpty)

        list.remove(1)
        list.remove(2)
        list.remove(3)

        assertEquals(true, list.isEmpty)
    }

    @Test
    fun `test add by index`() {
        val list = SingleLinkedList<Int>()

        list.add(1)
        list.add(3)
        list.add(5)

        assertEquals("""
            size: 3
            elements: 1 - 3 - 5
        """.trimIndent(), list.toString())

        list.add(1, 2)
        list.add(3, 4)

        assertEquals("""
            size: 5
            elements: 1 - 2 - 3 - 4 - 5
        """.trimIndent(), list.toString())
    }

    @Test
    fun `test addFirst`() {
        val list = SingleLinkedList<Int>()

        list.addFirst(100)
        list.addFirst(80)
        list.addFirst(60)
        list.addFirst(40)
        list.addFirst(20)

        assertEquals("""
            size: 5
            elements: 20 - 40 - 60 - 80 - 100
        """.trimIndent(), list.toString())

        list.remove(80)
        list.remove(40)

        assertEquals("""
            size: 3
            elements: 20 - 60 - 100
        """.trimIndent(), list.toString())

        list.addFirst(0)

        assertEquals("""
            size: 4
            elements: 0 - 20 - 60 - 100
        """.trimIndent(), list.toString())
    }

    @Test
    fun `test addLast`() {
        val list = SingleLinkedList<Int>()

        list.addLast(100)
        list.addLast(200)
        list.addLast(300)
        list.addLast(400)
        list.addLast(500)
        list.addLast(600)
        list.addLast(700)

        assertEquals("""
            size: 7
            elements: 100 - 200 - 300 - 400 - 500 - 600 - 700
        """.trimIndent(), list.toString())

        list.remove(200)
        list.remove(400)
        list.remove(600)

        assertEquals("""
            size: 4
            elements: 100 - 300 - 500 - 700
        """.trimIndent(), list.toString())

        list.addLast(900)

        assertEquals("""
            size: 5
            elements: 100 - 300 - 500 - 700 - 900
        """.trimIndent(), list.toString())
    }

    @Test
    fun `test contains`() {
        val list = SingleLinkedList<Int>()

        list.add(1)
        list.add(3)
        list.add(5)
        list.add(7)
        list.add(9)
        list.add(11)

        assertEquals(true, list.contains(1))
        assertEquals(true, list.contains(5))
        assertEquals(true, list.contains(9))
        assertEquals(true, list.contains(11))

        assertEquals(false, list.contains(2))
        assertEquals(false, list.contains(4))
        assertEquals(false, list.contains(8))
        assertEquals(false, list.contains(10))

        list.clear()

        assertEquals(false, list.contains(1))
        assertEquals(false, list.contains(5))
        assertEquals(false, list.contains(9))
        assertEquals(false, list.contains(11))
    }

    @Test
    fun `test remove and clear`() {
        val list = SingleLinkedList<Int>()

        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        assertEquals("""
            size: 5
            elements: 1 - 2 - 3 - 4 - 5
        """.trimIndent(), list.toString())

        assertEquals(true, list.remove(1))
        assertEquals(true, list.remove(3))
        assertEquals(true, list.remove(5))

        assertEquals("""
            size: 2
            elements: 2 - 4
        """.trimIndent(), list.toString())

        assertEquals(true, list.remove(2))
        assertEquals(true, list.remove(4))

        assertEquals(true, list.isEmpty)

        list.add(6)
        list.add(7)
        list.add(11)
        list.add(13)

        assertEquals("""
            size: 4
            elements: 6 - 7 - 11 - 13
        """.trimIndent(), list.toString())

        list.clear()

        assertEquals(true, list.isEmpty)
    }

}