package structures

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList

/**
 * структура данных: очередь
 *
 * описание: очередь организована по принципу FIFO (первый вошел, первый вышле), все операции выполняются за O(1), кроме
 * операции удаления из середины очереди, которая в худшем случае имеет время O(n)
 */

interface Queue<T> {

    /**
     * добавление в начало очереди
     *
     * @item - добавляемый элемент
     */
    fun offer(item: T)

    /**
     * возвращает элемент из начала очереди
     *
     * если очередь пуста, генерирует IllegalStateException
     */
    fun element() : T

    /**
     * возвращает элемент из начала очереди
     *
     * если очередь пуста вернет null
     */
    fun peek() : T?

    /**
     * удаляет и возвращает элемент из начала очереди
     *
     * если очередь пуста, генерирует IllegalStateException
     */
    fun remove() : T

    /**
     * удаляет и возвращает элемент из начала очереди
     *
     * если очередь пуста вернет null
     */
    fun poll() : T?

    /**
     * возвращает true, если очередь пуста
     *
     */
    fun isEmpty() : Boolean

    /**
     * очищает очередь
     *
     */
    fun clear()

    /**
     * удаляет элемент из середины очереди
     *
     * возвращает true, если элемент был успшешно удален
     */
    fun remove(item: T) : Boolean

    /**
     * реализация с использованием динамического массива ArrayList
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
     * реализация с использованием связанного списка LinkedList
     *
     */
    class LinkedListQueue<T> : Queue<T> {
        private val data = LinkedList<T>()

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