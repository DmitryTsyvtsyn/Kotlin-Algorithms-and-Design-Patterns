package structures

import java.util.LinkedList

/**
 *
 * Stack is a linear data structure that follows the LIFO (Last-In-First-Out) principle
 *
 * LIFO implies that the element that is inserted last, comes out first.
 *
 * The main operations:
 *
 *     push() - when we insert an element in a stack then the operation is known as a push.
 *     pop() - when we delete an element from the stack, the operation is known as a pop.
 *     If the stack is empty means that no element exists in the stack.
 *
 * All these operations performed in O(1) time.
 *
 */

class LinkedListStack<T> {
    // this implementation uses LinkedList
    private val data = LinkedList<T>()

    val isEmpty: Boolean
        get() = data.size == 0

    val size: Int
        get() = data.size

    fun push(item: T) {
        data.add(item)
    }

    fun pop(): T {
        if (isEmpty) {
            throw IllegalArgumentException("Stack is empty!")
        }
        return data.removeLast()
    }

    fun peek(): T {
        if (isEmpty) {
            throw IllegalArgumentException("Stack is empty!")
        }
        return data.peekLast()
    }

    fun clear() {
        data.clear()
    }

}