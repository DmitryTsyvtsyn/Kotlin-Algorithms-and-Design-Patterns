package structures

import java.util.LinkedList

/**
 *
 * Queue is a data structure that follows the FIFO (first in, first out) principle
 *
 * LIFO implies that the element that is inserted first, comes out first
 *
 * The main operations:
 *
 * 1) enqueue - inserts an element at the end of the queue
 * 2) dequeue - removes an element from the beginning of the queue
 *
 * All these operations performed in O(1) time.
 *
 */
class Queue<T> {

    private val data = LinkedList<T>()

    val isEmpty: Boolean
        get() = data.isEmpty()

    val size: Int
        get() = data.size

    fun enqueue(item: T) {
        data.add(item)
    }

    fun dequeue(): T {
        if (isEmpty) throw IllegalStateException("The queue is empty")

        // LinkedList under the hood stores a link to the first element
        // this operation will be completed in time O(1)
        return data.removeFirst()
    }

    fun peek(): T {
        if (isEmpty) throw IllegalStateException("The queue is empty")

        return data.first
    }

    fun clear() {
        data.clear()
    }

}