package structures

import java.util.LinkedList

/**
 *
 * Binary tree consists of nodes each of which has a maximum of two children.
 *
 * Child nodes satisfy the following requirements:
 *
 *  - the left child is less than the parent
 *  - right child is larger than parent
 *
 * Hint: the worst time may be O(n) because the situation is possible when the elements follow each other 1,2,3,4...
 * and the tree takes the following form:
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *
 */

class BinaryTree<T : Comparable<T>> {

    private var root: Node<T>? = null

    val isEmpty: Boolean
        get() = root == null

    /**
     * Complexity:
     * worst time: O(n), read the hint in the description
     * best time: O(log(n))
     * average time: O(log(n))
     */
    fun add(value: T) {
        fun addRecursive(current: Node<T>?, value: T): Node<T> {
            if (current == null) {
                return Node(value)
            }
            if (value < current.value()) {
                current.changeLeft(addRecursive(current.leftNode(), value))
            } else if (value > current.value()) {
                current.changeRight(addRecursive(current.rightNode(), value))
            }
            return current
        }

        root = addRecursive(root, value)
    }

    /**
     * Complexity:
     * worst time: O(n), read the hint in the description
     * best time: O(1)
     * average time: O(log(n))
     */
    fun remove(value: T) {
        fun smallestValue(root: Node<T>): T {
            val leftNode = root.leftNode()
            if (leftNode === null) return root.value()
            return smallestValue(leftNode)
        }

        fun removeRecursive(current: Node<T>?, value: T): Node<T>? {
            if (current == null) {
                return null
            }

            if (value == current.value()) {
                if (current.leftNode() == null && current.rightNode() == null) {
                    return null
                }
                if (current.leftNode() == null) {
                    return current.rightNode()
                }
                if (current.rightNode() == null) {
                    return current.leftNode()
                }

                val smallestValue = smallestValue(current.rightNode()!!)
                current.changeValue(smallestValue)
                current.changeRight(removeRecursive(current.rightNode(), smallestValue))
                return current
            }

            if (value < current.value()) {
                current.changeLeft(removeRecursive(current.leftNode(), value))
            } else {
                current.changeRight(removeRecursive(current.rightNode(), value))
            }

            return current
        }

        root = removeRecursive(root, value)
    }

    /**
     * Complexity:
     * worst time: O(n), read the hint in the description
     * best time: O(1)
     * average time: O(log(n))
     */
    fun contains(value: T): Boolean {
        fun containsRecursive(current: Node<T>?, value: T): Boolean {
            if (current == null) {
                return false
            }
            if (value == current.value()) {
                return true
            }
            return if (value < current.value()) {
                containsRecursive(current.leftNode(), value)
            } else {
                containsRecursive(current.rightNode(), value)
            }
        }

        return containsRecursive(root, value)
    }

    /**
     *
     * Traversal of the binary tree in depth
     *
     * order: the left child, the parent, the right child
     *
     */
    fun traverseInOrder(): List<T> {
        fun traverseInOrderRecursive(node: Node<T>?, nodes: MutableList<T>) {
            if (node != null) {
                traverseInOrderRecursive(node.leftNode(), nodes)
                nodes.add(node.value())
                traverseInOrderRecursive(node.rightNode(), nodes)
            }
        }

        val nodes = mutableListOf<T>()
        traverseInOrderRecursive(root, nodes)
        return nodes
    }

    /**
     *
     * Traversal of the binary tree in depth
     *
     * order: the parent, the left child, the right child
     *
     */
    fun traversePreOrder(): List<T> {
        fun traversePreOrderRecursive(node: Node<T>?, nodes: MutableList<T>) {
            if (node != null) {
                nodes.add(node.value())
                traversePreOrderRecursive(node.leftNode(), nodes)
                traversePreOrderRecursive(node.rightNode(), nodes)
            }
        }

        val nodes = mutableListOf<T>()
        traversePreOrderRecursive(root, nodes)
        return nodes
    }

    /**
     *
     * Traversal of the binary tree in depth
     *
     * order: the left child, the right child, the parent
     *
     */
    fun traversePostOrder(): List<T> {
        fun traversePostOrderRec(node: Node<T>?, nodes: MutableList<T>) {
            if (node != null) {
                traversePostOrderRec(node.leftNode(), nodes)
                traversePostOrderRec(node.rightNode(), nodes)
                nodes.add(node.value())
            }
        }

        val nodes = mutableListOf<T>()
        traversePostOrderRec(root, nodes)
        return nodes
    }

    /**
     *
     * Traversal of the binary tree in breadth uses an additional data structure - a queue into which new tree
     *
     * nodes are added until the last node is added
     *
     */
    fun traverseLevelOrder(): List<T> {
        val current = root ?: return emptyList()

        val queue = LinkedList<Node<T>>()
        queue.add(current)

        val nodeValues = mutableListOf<T>()

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()

            nodeValues.add(node.value())

            val leftNode = node.leftNode()
            if (leftNode != null) {
                queue.add(leftNode)
            }

            val rightNode = node.rightNode()
            if (rightNode != null) {
                queue.add(rightNode)
            }
        }

        return nodeValues
    }

    class Node<T>(
        private var value: T,
        private var left: Node<T>? = null,
        private var right: Node<T>? = null
    ) {

        fun value() = value
        fun changeValue(newValue: T) {
            value = newValue
        }

        fun leftNode() = left
        fun changeLeft(node: Node<T>?) {
            left = node
        }

        fun rightNode() = right
        fun changeRight(node: Node<T>?) {
            right = node
        }

    }

}