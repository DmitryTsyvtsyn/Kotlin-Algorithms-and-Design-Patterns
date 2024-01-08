package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class IteratorTest {

    @Test
    fun test() {
        val presents = arrayOf("chocolate cake", "snowboard", "snowman")
        val giftBox = GiftBox(presents)
        val giftBoxIterator = giftBox.iterator()
        val actualPresents = mutableListOf<String>()
        while (giftBoxIterator.hasNext()) {
            val present = giftBoxIterator.next()
            actualPresents.add(present)
        }
        assertEquals(presents.toList(), actualPresents)
    }

}