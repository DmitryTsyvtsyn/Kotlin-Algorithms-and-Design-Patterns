package structures

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList

/**
 * структура данных стэк
 *
 * операции добавления, вставки и удаления выполняется за O(1) время
 */

interface Stack<T> {
    /**
     * добавляет элемент на вершину стэка
     *
     * @item - элемент
     */
    fun push(item: T)

    /**
     * удаляет элемент на вершине стэка и возвращает его
     */
    fun pop() : T

    /**
     * возвращает элемент на вершине стэка без удаления
     */
    fun peek() : T

    /**
     * возвращает true, если стэк пустой
     */
    fun isEmpty() : Boolean

    /**
     * очищает стэк
     */
    fun clear()

    /**
     * реализация с использованием динамического массива ArrayList
     *
     * @T - тип элементов стэка
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
     * реализация с использованием связанного списка
     *
     * @T - тип элементов стэка
     */
    class LinkedListStack<T> : Stack<T> {
        private val data = LinkedList<T>()

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
