package structures

import java.util.*

class Node(
    private var value: Int,
    private var left: Node? = null,
    private var right: Node? = null
) {
    fun value() = value
    fun changeValue(value: Int) {
        this.value = value
    }
    fun changeLeft(left: Node?) {
        this.left = left
    }
    fun changeRight(right: Node?) {
        this.right = right
    }
    fun leftNode() = left
    fun rightNode() = right
}

class BinaryTree {

    private var root: Node? = null

    fun add(value: Int) = addRec(root, value)

    fun remove(value: Int) = removeRec(root, value)

    fun contains(value: Int) = containsRec(root, value)

    fun traverseInOrder() = traverseInOrderRec(root)
    fun traversePreOrder() = traversePreOrderRec(root)
    fun traversePostOrder() = traversePostOrderRec(root)

    fun traverseLevelOrder() {
        val root = this.root ?: return

        val queue = LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            println("${node.value()} ")
            if (node.leftNode() != null) {
                queue.add(node.leftNode()!!)
            }
            if (node.rightNode() != null) {
                queue.add(node.rightNode()!!)
            }
        }
    }

    private fun traverseInOrderRec(node: Node?) {
        if (node != null) {
            traverseInOrderRec(node.leftNode())
            println("${node.value()} ")
            traverseInOrderRec(node.rightNode())
        }
    }

    private fun traversePreOrderRec(node: Node?) {
        if (node != null) {
            println("${node.value()} ")
            traversePreOrderRec(node.leftNode())
            traversePreOrderRec(node.rightNode())
        }
    }

    private fun traversePostOrderRec(node: Node?) {
        if (node != null) {
            traversePostOrderRec(node.leftNode())
            traversePostOrderRec(node.rightNode())
            println("${node.value()} ")
        }
    }

    private fun smallestValue(root: Node) : Int {
        return if (root.leftNode() == null) root.value() else smallestValue(root.leftNode()!!)
    }

    private fun removeRec(current: Node?, value: Int) : Node? {
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
            current.changeRight(removeRec(current.rightNode(), smallestValue))
            return current
        }

        if (value < current.value()) {
            current.changeLeft(removeRec(current.leftNode(), value))
        } else {
            current.changeRight(removeRec(current.rightNode(), value))
        }

        return current
    }

    private fun containsRec(current: Node?, value: Int) : Boolean {
        if (current == null) {
            return false
        }
        if (value == current.value()) {
            return true
        }
        return if (value < current.value()) containsRec(current.leftNode(), value) else containsRec(current.rightNode(), value)
    }

    private fun addRec(current: Node?, value: Int) : Node {
        if (current == null) {
            return Node(value)
        }

        if (value < current.value()) {
            current.changeLeft(addRec(current.leftNode(), value))
        } else if (value > current.value()) {
            current.changeRight(addRec(current.rightNode(), value))
        } else {
            return current
        }
        return current
    }

}