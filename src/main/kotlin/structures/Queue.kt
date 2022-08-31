package structures

import kotlin.collections.ArrayList

/**
 * data structure: queue
 *
 * description: the queue is organized on a FIFO basis (first in, first out), all operations are performed in O(1),
 * except for the operation of deleting from the middle of the queue, which in the worst case takes O(n) time
 *
 */

interface Queue<T> {

    /**
     * adding to the front of the queue
     *
     * @param item - added element
     */
    fun offer(item: T)

    /**
     * returns the element from the front of the queue
     *
     * if the queue is empty, throws an IllegalStateException
     */
    fun element() : T

    /**
     * returns the element from the front of the queue
     *
     * if the queue is empty it will return null
     */
    fun peek() : T?

    /**
     * removes and returns an element from the front of the queue
     *
     * if the queue is empty, throws an IllegalStateException
     */
    fun remove() : T

    /**
     * removes and returns an element from the front of the queue
     *
     * if the queue is empty it will return null
     */
    fun poll() : T?

    /**
     *
     * @return returns true if the queue is empty
     */
    fun isEmpty() : Boolean

    /**
     * clears the queue
     *
     */
    fun clear()

    /**
     * removes an element from the middle of the queue
     *
     * @return returns true if the element was successfully removed
     */
    fun remove(item: T) : Boolean

    /**
     * implementation using dynamic ArrayList
     *
     */
    class ArrayListQueue<T> : Queue<T> {
        private val data = ArrayList<T>()

        override fun offer(item: T) = data.add(0, item)

        override fun isEmpty() = data.isEmpty()
        override fun clear() = data.clear()

        override fun element() = if (isEmpty()) thr("queue is empty!") else data.first()
        override fun peek() = if (isEmpty()) null else data.first()

        override fun remove() = if (isEmpty()) thr("queue is empty!") else data.removeFirst()
        override fun poll() = if (isEmpty()) null else data.removeFirst()

        override fun remove(item: T) : Boolean {
            return if (data.contains(item)) {
                data.remove(item)
                true
            } else {
                false
            }
        }

        private fun thr(msg: String) : Nothing {
            throw IllegalStateException(msg)
        }
    }

    /**
     * implementation using linked list LinkedList
     *
     */
    class LinkedListQueue<T> : Queue<T> {
        private val data = java.util.LinkedList<T>()

        override fun offer(item: T) = data.add(0, item)

        override fun isEmpty() = data.isEmpty()
        override fun clear() = data.clear()

        override fun element() : T = if (isEmpty()) thr("queue is empty!") else data.peekFirst()
        override fun peek() = if (isEmpty()) null else data.peekFirst()

        override fun remove(): T = if (isEmpty()) thr("queue is empty!") else data.removeFirst()
        override fun poll() = if (isEmpty()) null else data.removeFirst()

        override fun remove(item: T) : Boolean {
            return if (data.contains(item)) {
                data.remove(item)
                true
            } else {
                false
            }
        }

        private fun thr(msg: String) : Nothing {
            throw IllegalStateException(msg)
        }
    }


}