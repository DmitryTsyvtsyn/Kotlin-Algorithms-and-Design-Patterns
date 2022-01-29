package ru.structures

/**
 * структура данных: двусвязанный список
 *
 * описание: в связанном списке элементы ссылаются друг на друга.
 * возможно два варианта:
 * - ссылка только на следующий элемент (в таком случае мы содержим только одну корневую ссылку на первый элемент,
 * чтобы получить доступ к остальным)
 * - ссылка в оба направления (содержим две корневые ссылки: на первый и последний элементы)
 *
 * описание: в двусвязанном списке каждый элемент хранит ссылку на предыдущий и следующий элементы
 *
 * время вставки элемента в начало и конец: O(1)
 * время вставки в середину по индексу: O(n)
 * удаление: O(n)
 */

class DoubleLinkedList<T>(
    /**
     * хранит ссылку на первый элемент списка
     *
     * если список пустой, то ссылка null
     */
    private var first: Node<T>? = null,
    /**
     * хранит ссылку на последний элемент списка
     *
     * если список пустой, то ссылка null
     */
    private var last: Node<T>? = null
) {

    /**
     *  хранит количество элементов в списке
     *
     */
    private var count: Int = 0

    /**
     * узел двусвязанного списка
     *
     * @value - значение узла
     * @prev - ссылка на предыдущий элемент (при условии, что элемент не первый)
     * @next - ссылка на следующий элемент (при условии, что элемент не последний)
     */
    class Node<T>(
        private val value: T,
        private var prev: Node<T>? = null,
        private var next: Node<T>? = null
    ) {

        fun changeNext(next: Node<T>? = null) {
            this.next = next
        }

        fun changePrev(prev: Node<T>? = null) {
            this.prev = prev
        }

        fun next() = next
        fun prev() = prev
        fun value() = value

        fun isOne() = prev == null && next == null
        fun isFirst() = prev == null
        fun isLast() = next == null
    }

    /**
     *
     * @return возвращает количество элементов в списке
     */
    fun size() = count

    /**
     * простая функция, которая преобразует связанный список в обычной Kotlin список для наглядного представления
     *
     * @return возвращает Kotlin список элементов
     */
    fun toList() : List<T> {
        if (first == null) return listOf()

        val list = mutableListOf<T>()
        var node = first
        while (node != null) {
            list.add(node.value())
            node = node.next()
        }
        return list
    }

    /**
     * проверяет, есть ли элемент в списке
     *
     * @value - значение элемента
     *
     * @return возвращает true, если значение существует в списке
     */
    fun contains(value: T) : Boolean {
        if (first == null) return false

        var node = first
        while (node != null) {
            if (node.value() == value) {
                return true
            }
            node = node.next()
        }
        return false
    }

    /**
     * проверка на пустоту списка
     *
     * @return возвращает true, если список пустой
     */
    fun isEmpty() = first == null

    /**
     * удаляет элемент из списка
     *
     * @value - значение элемента
     *
     * @return возвращает true, если элемент был успешно удален
     */
    fun remove(value: T) : Boolean {
        if (first == null) return false

        var node = first

        while (node != null) {
            if (node.value() == value) {
                if (node.isOne()) {
                    first = null
                    last = null
                } else if (node.isFirst()) {
                    val next = node.next()
                    next?.changePrev(null)
                    first = next
                } else if (node.isLast()) {
                    val prev = node.prev()
                    prev?.changeNext(null)
                    last = prev
                } else {
                    node.prev()?.changeNext(node.next())
                    node.next()?.changePrev(node.prev())
                }
                count--
                return true
            }
            node = node.next()
        }
        return false
    }

    /**
     * добавляет элемент по индексу
     *
     * @index - индекс, куда нужно добавить новый элемент
     * @value - значение нового элемента
     *
     * @return возвращает true, если элемент был успешно добавлен по указанному индексу
     */
    fun add(index: Int, value: T) : Boolean {

        if (first == null) return false

        var i = 0
        var node = first
        while (node != null) {
            if (i == index) {
                val newNode = Node(value)

                newNode.changePrev(node.prev())
                newNode.changeNext(node)

                node.prev()?.changeNext(newNode)
                node.changePrev(newNode)

                count++
                return true
            }
            i++
            node = node.next()
        }

        return false
    }

    /**
     * аналогичный метод addLast
     *
     */
    fun add(value: T) = addLast(value)

    /**
     * добавляет элемент в начало списка
     *
     * @value - значение элемента
     */
    fun addFirst(value: T) {
        val firstNode = first
        first = if (firstNode == null) {
            Node(value)
        } else {
            val newNode = Node(value)
            newNode.changeNext(firstNode)
            firstNode.changePrev(newNode)
            newNode
        }
        if (last == null) {
            last = first
        }
        count++
    }

    /**
     * добавляет элемент в конец списка
     *
     * @value - значение элемента
     */
    fun addLast(value: T) {
        val lastNode = last
        last = if (lastNode == null) {
            Node(value)
        } else {
            val newNode = Node(value)
            lastNode.changeNext(newNode)
            newNode.changePrev(lastNode)
            newNode
        }
        if (first == null) {
            first = last
        }
        count++
    }

}