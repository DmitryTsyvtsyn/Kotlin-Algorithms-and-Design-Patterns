package structures

import java.util.*


/**
 * структура данных: бинарное дерево
 *
 * описание: состоит из узлов, каждый из которых имеет максимум два дочерних элемента,
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
     * добавление в дерево нового элемента
     *
     * @value - значение элемента
     */
    fun add(value: Int) {
        root = addRec(root, value)
    }

    /**
     * проверяет дерево на пустоту
     *
     * @return возвращает true, если дерево не содержит ни одного узла
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
     *
     * @return - возвращает true, если элемент существует
     */
    fun contains(value: Int) = containsRec(root, value)

    /**
     * обход в глубину
     *
     * сначала левый дочерний элемент, потом родитель, затем правый дочерний
     *
     * @return возвращает элементы дерева
     */
    fun traverseInOrder() : List<Int> {
        return mutableListOf<Int>().apply {
            traverseInOrderRec(root, this)
        }
    }

    /**
     * обход в глубину
     *
     * сначала родитель, затем левый и правый дочерние элементы
     *
     * @return возвращает элементы дерева
     */
    fun traversePreOrder() : List<Int> {
        return mutableListOf<Int>().apply {
            traversePreOrderRec(root, this)
        }
    }

    /**
     * обход в глубину
     *
     * сначала левый и правый дочерние элементы, затем родитель
     *
     * @return возвращает элементы дерева
     */
    fun traversePostOrder() : List<Int> {
        return mutableListOf<Int>().apply {
            traversePostOrderRec(root, this)
        }
    }

    /**
     * обход в ширину
     *
     * использует дополнительную структуру данных - очередь, в которую добавляет новые узлы дерева
     * до тех пор пока не добавит последний узел
     *
     * @return возвращает элементы дерева
     */
    fun traverseLevelOrder() : List<Int> {
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

    /**
     * большая часть алгоритмов с деревьями реализована в виде дополнительных рекурсивных функций
     *
     */

    private fun traverseInOrderRec(node: Node?, nodes: MutableList<Int>) {
        if (node != null) {
            traverseInOrderRec(node.leftNode(), nodes)
            nodes.add(node.value())
            traverseInOrderRec(node.rightNode(), nodes)
        }
    }

    private fun traversePreOrderRec(node: Node?, nodes: MutableList<Int>) {
        if (node != null) {
            nodes.add(node.value())
            traversePreOrderRec(node.leftNode(), nodes)
            traversePreOrderRec(node.rightNode(), nodes)
        }
    }

    private fun traversePostOrderRec(node: Node?, nodes: MutableList<Int>) {
        if (node != null) {
            traversePostOrderRec(node.leftNode(), nodes)
            traversePostOrderRec(node.rightNode(), nodes)
            nodes.add(node.value())
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

/**
 * представляет узел дерева
 *
 * @value - значение узла
 * @left - левый дочерний узел
 * @right - правый дочерний узел
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