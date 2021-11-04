package structures

import java.util.*

/**
 * представляет узел дерева
 *
 * @value - значение узла
 * @left - левый дочерний элемент
 * @right - правый дочерний элемент
 */
class Node(
    private var value: Int,
    private var left: Node? = null,
    private var right: Node? = null
) {
    /**
     * возвращает значение узла
     */
    fun value() = value

    /**
     * изменяет значение узла
     */
    fun changeValue(value: Int) {
        this.value = value
    }

    /**
     * изменяет левый дочерний узел
     */
    fun changeLeft(left: Node?) {
        this.left = left
    }

    /**
     * изменяет правый дочерний узел
     */
    fun changeRight(right: Node?) {
        this.right = right
    }

    /**
     * возвращает левый дочерний узел
     */
    fun leftNode() = left

    /**
     * возвращает правый дочерний узел
     */
    fun rightNode() = right
}

/**
 * бинарное дерево состоит из узлов, каждый из которых имеет максимум два дочерних элемента
 * дочерние узлы удовлетворяют следующим требованиям:
 *  - левый дочерний элемент меньше родителя;
 *  - правый дочерний элемент больше родителя;
 */

class BinaryTree {

    /**
     * корень дерева
     */
    private var root: Node? = null

    /**
     * добавление в дерево нового значения
     *
     * @value - значение
     */
    fun add(value: Int) {
        root = addRec(root, value)
    }

    /**
     * возвращает true, если дерево не содержит ни одного узла
     */
    fun isEmpty() = root == null

    /**
     * удаление из дерева элемента
     *
     * @value - значение элемента, который нужно удалить
     */
    fun remove(value: Int) {
        root = removeRec(root, value)
    }

    /**
     * проверка на существование элемента в дереве
     *
     * @value - значение элемента
     */
    fun contains(value: Int) = containsRec(root, value)

    /**
     * обход в глубину
     *
     * сначала левый дочерний элемент, потом родитель, затем правый дочерний
     */
    fun traverseInOrder() = traverseInOrderRec(root)

    /**
     * обход в глубину
     *
     * сначала родитель, затем левый и правый дочерние элементы
     */
    fun traversePreOrder() = traversePreOrderRec(root)

    /**
     * обход в глубину
     *
     * сначала левый и правый дочерние элементы, затем родитель
     */
    fun traversePostOrder() = traversePostOrderRec(root)

    /**
     * обход в ширину
     */
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

    /**
     * с помощью алгоритма обхода в ширину получает все элементы дерева и возвращает их
     */
    fun items() : List<Int> {
        val root = this.root ?: return listOf()

        val queue = LinkedList<Node>()
        queue.add(root)

        val items = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            items.add(node.value())
            if (node.leftNode() != null) {
                queue.add(node.leftNode()!!)
            }
            if (node.rightNode() != null) {
                queue.add(node.rightNode()!!)
            }
        }
        return items
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