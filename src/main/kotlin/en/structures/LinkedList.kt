package en.structures

/**
 * data structure: linked list
 *
 * description: in a linked list, elements refer to each other.
 * two options are possible:
 * - link only to the next element (in this case, we keep only one root link to the first element in order to access the rest)
 * - link in both directions (contains two root links: to the first and last elements)
 *
 * insertion time of the element at the beginning and end: O(1)
 * insertion time in the middle by index: O(n)
 * remove: O(n)
 */

class LinkedList<T>(
    /**
     * stores a reference to the first element of the list
     *
     * if the list is empty, then the reference is null
     */
    private var first: Node<T>? = null,
    /**
     * stores a reference to the last element of the list
     *
     * if the list is empty, then the reference is null
     */
    private var last: Node<T>? = null
) {

    /**
     * linked list node
     *
     * @value - node value
     * @prev - reference to the previous element (assuming the element is not the first one)
     * @next - link to the next element (assuming the element is not the last one)
     */
    class Node<T>(
        private val value: T,
        private var prev: Node<T>? = null,
        private var next: Node<T>? = null
    ) {

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

    /**
     * a simple function that converts a linked list into a normal Kotlin list for visualization
     *
     * @return returns Kotlin a list of elements
     */
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

    /**
     * checks if an element is in the list
     *
     * @value - element value
     *
     * @return returns true if the value exists in the list
     */
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

    /**
     * checking if the list is empty
     *
     * @return returns true if the list is empty
     */
    fun isEmpty() = first == null

    /**
     * removes an element from the list
     *
     * @value - element value
     *
     * @return returns true if the element was successfully removed
     */
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

    /**
     * add element by index
     *
     * @index - the index where the new element should be added
     * @value - the value of the new element
     *
     * @return returns true if the element was successfully added at the specified index
     */
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

    /**
     * similar addLast method
     *
     */
    fun add(value: T) = addLast(value)

    /**
     * adds an element to the beginning of the list
     *
     * @value - element value
     */
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

    /**
     * adds an element to the end of the list
     *
     * @value - element value
     */
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