package design_patterns

/**
 *
 * Iterator is a behavioral design pattern that provides a mechanism for sequentially enumerating the elements
 *
 * of a collection without revealing its internal representation.
 *
 */

interface BoxIterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

interface BoxIterable<T> {
    fun iterator(): BoxIterator<T>
}

class GiftBox(private val presents: Array<String>) : BoxIterable<String> {

    override fun iterator() = object : BoxIterator<String> {
        private var current = -1

        override fun next(): String {
            return presents[current]
        }

        override fun hasNext(): Boolean {
            if (current < presents.size - 1) {
                current++
                return true
            }
            return false
        }
    }

}