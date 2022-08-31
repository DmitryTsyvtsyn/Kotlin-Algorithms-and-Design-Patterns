package structures

/**
 * data structure: binary tree
 *
 * description: consists of nodes, each of which has a maximum of two children,
 * child nodes satisfy the following requirements:
 *  - the left child is less than the parent;
 *  - right child is larger than parent;
 *
 * average search time: log(n)
 * worst search time: n
 * because the situation is possible when the elements follow each other 1,2,3,4... and the tree takes the following form:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 * the same complexity is true for adding and removing nodes
 *
 */

class BinaryTree {

    /**
     * binary tree root
     */
    private var root: Node? = null

    /**
     * adding a new element to the tree
     *
     * @param value - element value
     */
    fun add(value: Int) {
        fun addRec(current: Node?, value: Int) : Node {
            if (current == null) {
                return Node(value)
            }
            if (value < current.value()) {
                current.changeLeft(addRec(current.leftNode(), value))
            } else if (value > current.value()) {
                current.changeRight(addRec(current.rightNode(), value))
            }
            return current
        }

        root = addRec(root, value)
    }

    /**
     * checks the tree for emptiness
     *
     * @return returns true if the tree does not contain any nodes
     */
    fun isEmpty() = root == null

    /**
     * removing an element from the tree
     *
     * @param value - the value of the element to be removed
     */
    fun remove(value: Int) {
        fun smallestValue(root: Node) : Int {
            return if (root.leftNode() == null) root.value() else smallestValue(root.leftNode()!!)
        }

        fun removeRec(current: Node?, value: Int) : Node? {
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

        root = removeRec(root, value)
    }

    /**
     * checking for the existence of an element in the tree
     *
     * @param value - element value
     *
     * @return - returns true if the element exists
     */
    fun contains(value: Int) : Boolean {
        fun containsRec(current: Node?, value: Int) : Boolean {
            if (current == null) {
                return false
            }
            if (value == current.value()) {
                return true
            }
            return if (value < current.value()) {
                containsRec(current.leftNode(), value)
            } else {
                containsRec(current.rightNode(), value)
            }
        }

        return containsRec(root, value)
    }

    /**
     * traversal of the binary tree in depth
     *
     * first the left child, then the parent, then the right child
     *
     * @return returns the elements of the tree
     */
    fun traverseInOrder() : List<Int> {
        fun traverseInOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                traverseInOrderRec(node.leftNode(), nodes)
                nodes.add(node.value())
                traverseInOrderRec(node.rightNode(), nodes)
            }
        }

        return mutableListOf<Int>().apply {
            traverseInOrderRec(root, this)
        }
    }

    /**
     * traversal of the binary tree in depth
     *
     * parent first, then left and right children
     *
     * @return returns the elements of the tree
     */
    fun traversePreOrder() : List<Int> {
        fun traversePreOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                nodes.add(node.value())
                traversePreOrderRec(node.leftNode(), nodes)
                traversePreOrderRec(node.rightNode(), nodes)
            }
        }

        return mutableListOf<Int>().apply {
            traversePreOrderRec(root, this)
        }
    }

    /**
     * traversal of the binary tree in depth
     *
     * first the left and right children, then the parent
     *
     * @return returns the elements of the tree
     */
    fun traversePostOrder() : List<Int> {
        fun traversePostOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                traversePostOrderRec(node.leftNode(), nodes)
                traversePostOrderRec(node.rightNode(), nodes)
                nodes.add(node.value())
            }
        }

        return mutableListOf<Int>().apply {
            traversePostOrderRec(root, this)
        }
    }

    /**
     * traversal of the binary tree in breadth
     *
     * uses an additional data structure - a queue into which new tree
     * nodes are added until the last node is added
     *
     * @return returns the elements of the tree
     */
    fun traverseLevelOrder() : List<Int> {
        val root = this.root ?: return listOf()

        val queue = java.util.LinkedList<Node>()
        queue.add(root)

        val items = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            items.add(node.value())

            node.leftNode()?.let(queue::add)
            node.rightNode()?.let(queue::add)
        }

        return items
    }

}

/**
 * represents a tree node
 *
 * @constructor
 * @property value - node value
 * @property left - left child node
 * @property right - right child node
 *
 */
class Node(
    private var value: Int,
    private var left: Node? = null,
    private var right: Node? = null
) {
    /**
     * returns the value of the node
     */
    fun value() = value

    /**
     * changes the value of a node
     */
    fun changeValue(value: Int) {
        this.value = value
    }

    /**
     * changes the left child node
     */
    fun changeLeft(left: Node?) {
        this.left = left
    }

    /**
     * changes the right child node
     */
    fun changeRight(right: Node?) {
        this.right = right
    }

    /**
     * returns the left child node
     */
    fun leftNode() = left

    /**
     * returns the right child node
     */
    fun rightNode() = right
}