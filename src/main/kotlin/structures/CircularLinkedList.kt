package structures

/**
 *
 * LinkedList a data structure consisting of a collection of nodes that contain a link to the next/previous node.
 *
 * In the single LinkedList with circular reference each node contains a link to the next element,
 * the last one refers to the first
 *
 */

class CircularLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var size: Int = 0

    val isEmpty: Boolean
        get() = head == null

    /**
     * The simple method to test functionality of the LinkedList with circular reference
     *
     * Complexity: O(n * cycleNumber)
     */
    fun cyclingList(cycleNumber: Int = 1): List<T> {
        val nodeList = mutableListOf<T>()
        var currentCycle = 0

        if (isEmpty) return nodeList

        while (currentCycle < cycleNumber) {

            var node = head
            while (node != null) {
                val nodeValue = node.value()
                if (nodeValue != null) {
                    nodeList.add(nodeValue)
                }

                if (node === tail) {
                    currentCycle++
                    break
                }

                node = node.next()
            }

        }

        return nodeList
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
                prevNode.changeNext(newNode)
                size++
                return true
            }
            i++

            if (node === tail) {
                break
            }

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
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            node.changeNext(head)
            head = node
        }
        tail?.changeNext(head)
        size++
    }

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun addLast(value: T) {
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.changeNext(node)
            tail = node
        }
        tail?.changeNext(head)
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

            if (node === tail) {
                break
            }

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
            currentNode.changeValue(null)

            if (currentNode === tail) {
                break
            }
        }

        head = null
        tail = null
        size = 0
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
                var nextNode = node.next()
                if (nextNode === head) {
                    nextNode = null
                }
                previous?.changeNext(nextNode)

                if (head === node) {
                    head = nextNode
                }

                if (tail === node) {
                    tail = previous
                }

                node.changeNext(null)
                node.changeValue(null)

                tail?.changeNext(head)

                size--

                return true
            }

            if (node === tail) {
                break
            }

            previous = node
            node = node.next()
        }

        return false
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("size: $size\n")
        builder.append("elements: ")

        var node = head
        while (node != null) {
            builder.append(node.value())

            // it's necessary to see the correct node connections
            if (node.next() != null) {
                builder.append(" - ")
            }

            if (node === tail) {
                break
            }

            node = node.next()
        }

        return builder.toString()
    }

    class Node<T>(
        private var value: T? = null,
        private var next: Node<T>? = null
    ) {

        fun next() = next
        fun changeNext(node: Node<T>? = null) {
            next = node
        }

        fun value() = value
        fun changeValue(newValue: T?) {
            value = newValue
        }
    }

}