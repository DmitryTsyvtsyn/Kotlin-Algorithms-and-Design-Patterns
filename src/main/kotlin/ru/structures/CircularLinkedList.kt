package ru.structures

/**
 * структура данных: односвязанный список с циклической ссылкой (последний ссылается на первый)
 *
 * описание: каждый элемент хранит ссылку на следующий элемент, последний ссылается на первый
 *
 * время вставки элемента в начало и в конец списка: O(1)
 * время вставки в середину по индексу: O(n)
 * удаление: O(n)
 */

class CircularLinkedList<T>(
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
    private var last: Node<T>? = null,
) {

    /**
     *  хранит количество элементов в списке
     *
     */
    private var count: Int = 0

    /**
     * узел односвязанного списка
     *
     * @value - значение узла
     * @next - ссылка на следующий элемент (при условии, что элемент не последний)
     */
    class Node<T>(
        private val value: T,
        private var next: Node<T>? = null
    ) {

        fun changeNext(next: Node<T>? = null) {
            this.next = next
        }

        fun next() = next
        fun value() = value
    }

    /**
     *
     * @return возвращает количество элементов в списке
     */
    fun size() = count

    /**
     *
     * @return возвращает true, если последний элемент ссылается на первый
     */
    fun isCircular() = last?.next()?.value() == first?.value()

    /**
     * простая функция, которая преобразует список в обычной Kotlin список для наглядного представления
     *
     * @return возвращает Kotlin список элементов
     */
    fun toList() : List<T> {
        if (first == null) return listOf()

        val list = mutableListOf<T>()
        var node = first
        for (i in 0 until count) {
            if (node != null) {
                list.add(node.value())
            }
            node = node?.next()
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
        for (i in 0 until count) {
            if (node?.value() == value) {
                return true
            }
            node = node?.next()
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
        if (first == null) {
            return false
        }

        var prev = first
        var node = first

        for (i in 0 until count) {
            if (node?.value() == value) {
                if (prev?.value() == node?.value()) {
                    this.first = null
                    this.last = null
                } else {
                    prev?.changeNext(node?.next())
                }
                this.last?.changeNext(this.first)
                count--
                return true
            }
            prev = node
            node = node?.next()
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

        var node = first

        for (i in 0 until count - 1) {
            if (i == index) {
                val newNode = Node(value)
                node?.changeNext(newNode)
                this.last?.changeNext(this.first)
                count++
                return true
            }
            node = node?.next()
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
        val node = Node(value)
        if (first == null) {
            this.first = node
            this.last = node
        } else {
            node.changeNext(first)
            this.first = node
        }
        this.last?.changeNext(this.first)
        count++
    }

    /**
     * добавляет элемент в конец списка
     *
     * @value - значение элемента
     */
    fun addLast(value: T) {
        val newNode = Node(value)
        if (first == null) {
            this.first = newNode
            this.last = newNode
        } else {
            this.last?.changeNext(newNode)
            this.last = newNode
        }
        this.last?.changeNext(this.first)
        count++
    }

}