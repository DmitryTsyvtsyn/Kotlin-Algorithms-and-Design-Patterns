package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class BinaryTreeTest {

    @Test
    fun test() {
        val tree = BinaryTree()

        tree.add(5)
        tree.add(10)
        tree.add(4)

        assertEquals(listOf(4, 5, 10), tree.items().sorted())

        tree.remove(10)

        assertEquals(listOf(4, 5), tree.items().sorted())
        assertEquals(true, tree.contains(4))

        tree.remove(4)
        tree.remove(5)

        assertEquals(true, tree.isEmpty())

    }

}