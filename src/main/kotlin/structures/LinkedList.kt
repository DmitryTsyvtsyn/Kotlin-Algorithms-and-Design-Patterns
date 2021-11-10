package structures

/**
 * структура данных: связанный список
 *
 * описание: в связанном списке элементы ссылаются друг на друга.
 * возможно два варианта:
 * - ссылка только на следующий элемент (в таком случае мы содержим только одну корневую ссылку на первый элемент,
 * чтобы получить доступ к остальным)
 * - ссылка в оба направления (содержим две корневые ссылки: на первый и последний элементы)
 *
 * время вставки элемента в начало и конец: O(1)
 * время вставки в середину по индексу: O(n)
 * удаление: O(n)
 */

class LinkedList<T>(
    private var first: Node<T>? = null,
    private var last: Node<T>? = null
) {

    class Node<T>(private val value: T, private var prev: Node<T>? = null, private var next: Node<T>? = null) {

        fun changeNext(next: Node<T>? = null) {
            this.next = next
        }

        fun changePrev(prev: Node<T>? = null) {
            this.prev = prev
        }

        fun next() = next
        fun prev() = prev
        fun value() = value

        fun isOne() = prev == null && next == null
        fun isFirst() = prev == null
        fun isLast() = next == null
    }

    fun toList() : List<T> {
        if (first == null) return listOf()

        val list = mutableListOf<T>()
        var node = first
        while (node != null) {
            list.add(node.value())
            node = node.next()
        }
        return list
    }

    fun contains(value: T) : Boolean {
        if (first == null) return false

        var node = first
        while (node != null) {
            if (node.value() == value) {
                return true
            }
            node = node.next()
        }
        return false
    }

    fun isEmpty() = first == null

    fun remove(value: T) : Boolean {
        if (first == null) return false

        var node = first

        while (node != null) {
            if (node.value() == value) {
                if (node.isOne()) {
                    first = null
                    last = null
                } else if (node.isFirst()) {
                    val next = node.next()
                    next?.changePrev(null)
                    first = next
                } else if (node.isLast()) {
                    val prev = node.prev()
                    prev?.changeNext(null)
                    last = prev
                } else {
                    node.prev()?.changeNext(node.next())
                    node.next()?.changePrev(node.prev())
                }

                return true
            }
            node = node.next()
        }
        return false
    }

    fun add(index: Int, value: T) : Boolean {

        if (first == null) return false

        var i = 0
        var node = first
        while (node != null) {
            if (i == index) {
                val newNode = Node(value)

                newNode.changePrev(node.prev())
                newNode.changeNext(node)

                node.prev()?.changeNext(newNode)
                node.changePrev(newNode)

                return true
            }
            i++
            node = node.next()
        }

        return false
    }

    fun add(value: T) = addLast(value)

    fun addFirst(value: T) {
        val firstNode = first
        first = if (firstNode == null) {
            Node(value)
        } else {
            val newNode = Node(value)
            newNode.changeNext(firstNode)
            firstNode.changePrev(newNode)
            newNode
        }
        if (last == null) {
            last = first
        }
    }

    fun addLast(value: T) {
        val lastNode = last
        last = if (lastNode == null) {
            Node(value)
        } else {
            val newNode = Node(value)
            lastNode.changeNext(newNode)
            newNode.changePrev(lastNode)
            newNode
        }
        if (first == null) {
            first = last
        }
    }

}