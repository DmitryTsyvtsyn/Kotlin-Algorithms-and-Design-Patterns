package structures

import org.junit.Test
import org.junit.Assert.assertEquals

internal class BinaryTreeTest {

    @Test
    fun `test add`() {
        val tree = BinaryTree<Int>()

        tree.add(5)
        tree.add(10)
        tree.add(4)

        assertEquals(listOf(5, 4, 10), tree.traverseLevelOrder())

        tree.add(9)

        assertEquals(listOf(5, 4, 10, 9), tree.traverseLevelOrder())

        tree.add(1)

        assertEquals(listOf(5, 4, 10, 1, 9), tree.traverseLevelOrder())

        tree.add(11)

        assertEquals(listOf(5, 4, 10, 1, 9, 11), tree.traverseLevelOrder())
    }

    @Test
    fun `test remove`() {
        val tree = BinaryTree<Int>()

        tree.add(10)
        tree.add(20)
        tree.add(30)

        assertEquals(listOf(10, 20, 30), tree.traverseLevelOrder())
        assertEquals(false, tree.isEmpty)

        tree.remove(20)

        assertEquals(listOf(10, 30), tree.traverseLevelOrder())
        assertEquals(false, tree.isEmpty)

        tree.remove(10)

        assertEquals(listOf(30), tree.traverseLevelOrder())
        assertEquals(false, tree.isEmpty)

        tree.remove(30)

        assertEquals(emptyList<Int>(), tree.traverseLevelOrder())
        assertEquals(true, tree.isEmpty)
    }

    @Test
    fun `test is empty`() {
        val tree = BinaryTree<Int>()

        assertEquals(true, tree.isEmpty)

        tree.add(10)

        assertEquals(false, tree.isEmpty)

        tree.add(20)

        assertEquals(false, tree.isEmpty)

        tree.remove(10)

        assertEquals(false, tree.isEmpty)

        tree.remove(20)

        assertEquals(true, tree.isEmpty)
    }

    @Test
    fun `test contains`() {
        val tree = BinaryTree<Int>()

        assertEquals(false, tree.contains(5))
        assertEquals(false, tree.contains(3))
        assertEquals(false, tree.contains(7))

        tree.add(5)
        tree.add(3)
        tree.add(7)

        assertEquals(true, tree.contains(5))
        assertEquals(true, tree.contains(3))
        assertEquals(true, tree.contains(7))

        assertEquals(false, tree.contains(2))
        assertEquals(false, tree.contains(10))

        tree.add(2)
        tree.add(10)

        assertEquals(true, tree.contains(2))
        assertEquals(true, tree.contains(10))

        tree.remove(5)
        tree.remove(3)
        tree.remove(7)
        tree.remove(2)

        assertEquals(false, tree.contains(5))
        assertEquals(false, tree.contains(3))
        assertEquals(false, tree.contains(7))
        assertEquals(false, tree.contains(2))
        assertEquals(true, tree.contains(10))
    }

    @Test
    fun `test traverseInOrder`() {
        val tree = BinaryTree<Int>()

        assertEquals(emptyList<Int>(), tree.traverseInOrder())

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(2, 3, 5, 8, 9), tree.traverseInOrder())

        tree.add(1)
        tree.add(11)

        assertEquals(listOf(1, 2, 3, 5, 8, 9, 11), tree.traverseInOrder())

        tree.add(20)
        tree.add(30)

        assertEquals(listOf(1, 2, 3, 5, 8, 9, 11, 20, 30), tree.traverseInOrder())
    }

    @Test
    fun `test traversePreOrder`() {
        val tree = BinaryTree<Int>()

        assertEquals(emptyList<Int>(), tree.traversePreOrder())

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(5, 3, 2, 8, 9), tree.traversePreOrder())

        tree.add(1)
        tree.add(11)

        assertEquals(listOf(5, 3, 2, 1, 8, 9, 11), tree.traversePreOrder())

        tree.add(0)
        tree.add(20)

        assertEquals(listOf(5, 3, 2, 1, 0, 8, 9, 11, 20), tree.traversePreOrder())
    }

    @Test
    fun `test traversePostOrder`() {
        val tree = BinaryTree<Int>()

        assertEquals(emptyList<Int>(), tree.traversePostOrder())

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(2, 3, 9, 8, 5), tree.traversePostOrder())

        tree.add(1)
        tree.add(11)

        assertEquals(listOf(1, 2, 3, 11, 9, 8, 5), tree.traversePostOrder())

        tree.add(0)
        tree.add(20)

        assertEquals(listOf(0, 1, 2, 3, 20, 11, 9, 8, 5), tree.traversePostOrder())
    }

    @Test
    fun `test traverseLevelOrder`() {
        val tree = BinaryTree<Int>()

        assertEquals(emptyList<Int>(), tree.traverseLevelOrder())

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(5, 3, 8, 2, 9), tree.traverseLevelOrder())

        tree.add(1)
        tree.add(11)

        assertEquals(listOf(5, 3, 8, 2, 9, 1, 11), tree.traverseLevelOrder())

        tree.add(0)
        tree.add(20)
        tree.add(30)

        assertEquals(listOf(5, 3, 8, 2, 9, 1, 11, 0, 20, 30), tree.traverseLevelOrder())
    }

}