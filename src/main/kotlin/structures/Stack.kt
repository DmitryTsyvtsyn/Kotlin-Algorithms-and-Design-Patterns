package structures

import java.lang.IllegalArgumentException
import kotlin.collections.ArrayList

/**
 *
 * data structure: stack
 *
 * description: the stack uses the LIFO principle (last in, first out), all operations are performed in O(1) time
 *
 */

interface Stack<T> {

    /**
     * adds an element [item] to the top of the stack
     */
    fun push(item: T)

    /**
     * removes the element at the top of the stack and returns it
     */
    fun pop() : T

    /**
     * returns the element at the top of the stack without removing
     */
    fun peek() : T

    /**
     * returns true if the stack is empty
     */
    fun isEmpty() : Boolean

    /**
     * clears the stack
     */
    fun clear()

    /**
     * implementation using ArrayList
     *
     * @param T - stack element type
     */
    class ArrayListStack<T> : Stack<T> {
        private val data = ArrayList<T>()

        override fun push(item: T) {
            data.add(item)
        }

        override fun pop() : T {
            if (isEmpty()) {
                throw IllegalArgumentException("Stack is empty!")
            }
            return data.removeLast()
        }

        override fun peek() : T {
            if (isEmpty()) {
                throw IllegalArgumentException("Stack is empty!")
            }
            return data.last()
        }

        override fun isEmpty() = data.isEmpty()

        override fun clear() {
            data.clear()
        }
    }

    /**
     * linked list implementation
     *
     * @param T - stack element type
     */
    class LinkedListStack<T> : Stack<T> {
        private val data = java.util.LinkedList<T>()

        override fun push(item: T) {
            data.add(item)
        }

        override fun pop(): T {
            if (isEmpty()) {
                throw IllegalArgumentException("Stack is empty!")
            }
            return data.removeLast()
        }

        override fun peek(): T {
            if (isEmpty()) {
                throw IllegalArgumentException("Stack is empty!")
            }
            return data.peekLast()
        }

        override fun isEmpty() = data.isEmpty()

        override fun clear() {
            data.clear()
        }

    }
}
