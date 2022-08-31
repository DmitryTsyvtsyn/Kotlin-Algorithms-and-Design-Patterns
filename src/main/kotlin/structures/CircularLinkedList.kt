package structures

/**
 * data structure: singly linked list with circular reference (last refers to first)
 *
 * description: each element stores a link to the next element, the last one refers to the first
 *
 * time to insert an element at the beginning and end of the list: O(1)
 * insertion time in the middle by index: O(n)
 * delete: O(n)
 *
 */

class CircularLinkedList<T>(
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
    private var last: Node<T>? = null,
) {

    /**
     *  stores the number of elements in the list
     *
     */
    private var count: Int = 0

    /**
     * singly linked list node
     *
     * @constructor
     * @property value - node value
     * @property next - link to the next element (assuming the element is not the last one)
     *
     */
    class Node<T>(
        private val value: T,
        private var next: Node<T>? = null
    ) {

        fun changeNext(next: Node<T>? = null) {
            this.next = next
        }

        fun next() = next
        fun value() = value
    }

    /**
     *
     * @return returns the number of elements in the list
     */
    fun size() = count

    /**
     *
     * @return returns true if the last element refers to the first
     */
    fun isCircular() = last?.next()?.value() == first?.value()

    /**
     * a simple function that converts a list into a normal Kotlin list for visual representation
     *
     * @return returns Kotlin a list of elements
     */
    fun toList() : List<T> {
        if (first == null) return listOf()

        val list = mutableListOf<T>()
        var node = first
        for (i in 0 until count) {
            if (node != null) {
                list.add(node.value())
            }
            node = node?.next()
        }

        return list
    }

    /**
     * checks if an element is in the list
     *
     * @param value - element value
     *
     * @return returns true if the value exists in the list
     */
    fun contains(value: T) : Boolean {
        if (first == null) return false

        var node = first
        for (i in 0 until count) {
            if (node?.value() == value) {
                return true
            }
            node = node?.next()
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
     * @param value - element value
     *
     * @return returns true if the element was successfully removed
     */
    fun remove(value: T) : Boolean {
        if (first == null) {
            return false
        }

        var prev = first
        var node = first

        for (i in 0 until count) {
            if (node?.value() == value) {
                if (prev?.value() == node?.value()) {
                    this.first = null
                    this.last = null
                } else {
                    prev?.changeNext(node?.next())
                }
                this.last?.changeNext(this.first)
                count--
                return true
            }
            prev = node
            node = node?.next()
        }
        return false
    }

    /**
     * add element by index
     *
     * @param index - the index where the new element should be added
     * @param value - the value of the new element
     *
     * @return returns true if the element was successfully added at the specified index
     */
    fun add(index: Int, value: T) : Boolean {

        if (first == null) return false

        var node = first

        for (i in 0 until count - 1) {
            if (i == index) {
                val newNode = Node(value)
                node?.changeNext(newNode)
                this.last?.changeNext(this.first)
                count++
                return true
            }
            node = node?.next()
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
     * @param value - element value
     */
    fun addFirst(value: T) {
        val node = Node(value)
        if (first == null) {
            this.first = node
            this.last = node
        } else {
            node.changeNext(first)
            this.first = node
        }
        this.last?.changeNext(this.first)
        count++
    }

    /**
     * adds an element to the end of the list
     *
     * @param value - element value
     */
    fun addLast(value: T) {
        val newNode = Node(value)
        if (first == null) {
            this.first = newNode
            this.last = newNode
        } else {
            this.last?.changeNext(newNode)
            this.last = newNode
        }
        this.last?.changeNext(this.first)
        count++
    }

}