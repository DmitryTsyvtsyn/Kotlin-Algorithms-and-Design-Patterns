package structures

import java.lang.IllegalArgumentException
import java.util.ArrayList

/**
 *
 * Stack is a linear data structure that follows the LIFO (last in first out) principle
 *
 * LIFO implies that the element that is inserted last, comes out first.
 *
 * The main operations:
 *
 * 1) push() - when we insert an element in a stack then the operation is known as a push
 * 2) pop() - when we delete an element from the stack, the operation is known as a pop
 *
 * All these operations performed in O(1) time.
 *
 */

class Stack1<T> {
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