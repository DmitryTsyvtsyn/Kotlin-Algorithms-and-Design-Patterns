package structures

/**
 *
 * LinkedList a data structure consisting of a collection of nodes that contain a link to the next/previous node.
 *
 * In the double LinkedList each node contains a link to the previous and next elements
 *
 */

class DoubleLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var size: Int = 0

    val isEmpty: Boolean
        get() = head == null

    // Complexity: O(n)
    val list: List<T>
        get() {
            val nodes = mutableListOf<T>()
            var node = head
            while (node != null) {
                val nodeValue = node.value()
                if (nodeValue != null) {
                    nodes.add(nodeValue)
                }
                node = node.next()
            }
            return nodes
        }

    // Complexity: O(n)
    val reversedList: List<T>
        get() {
            val nodes = mutableListOf<T>()
            var node = tail
            while (node != null) {
                val nodeValue = node.value()
                if (nodeValue != null) {
                    nodes.add(nodeValue)
                }
                node = node.previous()
            }
            return nodes
        }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun add(index: Int, value: T) : Boolean {
        if (head == null) return false

        var i = 0
        var node = head
        var prevNode = head
        while (prevNode != null && node != null) {
            if (i == index) {
                val newNode = Node(value)
                newNode.changeNext(node)
                newNode.changePrevious(prevNode)
                prevNode.changeNext(newNode)
                size++
                return true
            }
            i++
            prevNode = node
            node = node.next()
        }

        return false
    }

    fun add(value: T) = addLast(value)

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun addFirst(value: T) {
        val headNode = head
        head = if (headNode == null) {
            Node(value)
        } else {
            val newNode = Node(value = value, next = headNode)
            headNode.changePrevious(newNode)
            newNode
        }
        if (tail == null) {
            tail = head
        }
        size++
    }

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun addLast(value: T) {
        val tailNode = tail
        tail = if (tailNode == null) {
            Node(value)
        } else {
            val newNode = Node(value = value, previous = tailNode)
            tailNode.changeNext(newNode)
            newNode
        }
        if (head == null) {
            head = tail
        }
        size++
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun contains(value: T) : Boolean {
        if (head == null) return false

        var node = head
        while (node != null) {
            if (node.value() == value) {
                return true
            }
            node = node.next()
        }
        return false
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun remove(value: T) : Boolean {
        if (head == null) return false

        var previous: Node<T>? = null
        var node = head

        while (node != null) {
            if (node.value() == value) {
                val nextNode = node.next()
                previous?.changeNext(nextNode)
                nextNode?.changePrevious(previous)

                if (node === head) {
                    head = nextNode
                }

                if (node === tail) {
                    tail = previous
                }

                node.changePrevious(null)
                node.changeNext(null)
                node.changeValue(null)

                size--
                return true
            }
            previous = node
            node = node.next()
        }

        return false
    }

    // Complexity: O(n)
    fun clear() {
        var node = head
        while (node != null) {
            val currentNode = node

            node = node.next()

            currentNode.changeNext(null)
            currentNode.changePrevious(null)
            currentNode.changeValue(null)
        }

        head = null
        tail = null
        size = 0
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("size: $size\n")
        builder.append("elements: ")

        var node = head
        while (node != null) {

            // it's necessary to see the correct node connections
            if (node.previous() != null) {
                builder.append("- ")
            }

            builder.append(node.value())

            // it's necessary to see the correct node connections
            if (node.next() != null) {
                builder.append(" -")
            }

            node = node.next()
        }

        return builder.toString()
    }

    class Node<T>(
        private var value: T? = null,
        private var previous: Node<T>? = null,
        private var next: Node<T>? = null
    ) {

        fun next() = next
        fun changeNext(node: Node<T>? = null) {
            next = node
        }

        fun previous() = previous
        fun changePrevious(node: Node<T>? = null) {
            previous = node
        }

        fun value() = value
        fun changeValue(newValue: T?) {
            value = newValue
        }

    }

}