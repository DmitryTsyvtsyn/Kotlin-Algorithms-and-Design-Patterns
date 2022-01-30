package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class BinaryTreeTest {

    @Test
    fun test_add() {
        val tree = BinaryTree()

        tree.add(5)
        tree.add(10)
        tree.add(4)

        assertEquals(listOf(4, 5, 10), tree.traverseInOrder().sorted())
    }

    @Test
    fun test_remove() {
        val tree = BinaryTree()

        tree.add(10)
        tree.add(20)
        tree.add(30)

        assertEquals(listOf(10, 20, 30), tree.traverseInOrder().sorted())

        tree.remove(20)

        assertEquals(listOf(10, 30), tree.traverseInOrder().sorted())

        tree.remove(10)

        assertEquals(listOf(30), tree.traverseInOrder().sorted())
    }

    @Test
    fun test_is_empty() {
        val tree = BinaryTree()

        assertEquals(true, tree.isEmpty())

        tree.add(10)

        assertEquals(false, tree.isEmpty())

        tree.remove(10)

        assertEquals(true, tree.isEmpty())
    }

    @Test
    fun test_contains() {
        val tree = BinaryTree()

        assertEquals(false, tree.contains(10))

        tree.add(5)
        tree.add(3)
        tree.add(7)
        tree.add(2)
        tree.add(10)

        assertEquals(true, tree.contains(10))
    }

    @Test
    fun test_traverse_in_order() {
        val tree = BinaryTree()

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(2, 3, 5, 8, 9), tree.traverseInOrder())
    }

    @Test
    fun test_traverse_pre_order() {
        val tree = BinaryTree()

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(5, 3, 2, 8, 9), tree.traversePreOrder())
    }

    @Test
    fun test_traverse_post_order() {
        val tree = BinaryTree()

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(2, 3, 9, 8, 5), tree.traversePostOrder())
    }

    @Test
    fun test_traverse_level_order() {
        val tree = BinaryTree()

        tree.add(5)
        tree.add(3)
        tree.add(8)
        tree.add(2)
        tree.add(9)

        assertEquals(listOf(5, 3, 8, 2, 9), tree.traverseLevelOrder())
    }

}