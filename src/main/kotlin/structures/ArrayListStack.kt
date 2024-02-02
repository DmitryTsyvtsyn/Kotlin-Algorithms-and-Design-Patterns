package structures

import java.lang.IllegalArgumentException
import java.util.ArrayList

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

class ArrayListStack<T> {
    // this implementation uses ArrayList
    private val data = ArrayList<T>()

    val isEmpty: Boolean
        get() = data.size == 0

    val size: Int
        get() = data.size

    fun push(item: T) {
        data.add(item)
    }

    fun pop() : T {
        if (isEmpty) {
            throw IllegalArgumentException("Stack is empty!")
        }
        return data.removeLast()
    }

    fun peek() : T {
        if (isEmpty) {
            throw IllegalArgumentException("Stack is empty!")
        }
        return data.last()
    }

    fun clear() {
        data.clear()
    }

}