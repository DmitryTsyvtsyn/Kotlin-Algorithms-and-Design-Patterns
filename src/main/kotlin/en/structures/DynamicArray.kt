package en.structures

import java.lang.IllegalStateException

/**
 * структура данных: динамический массив
 *
 * описание: обертка над обычным массивом, в которой осуществляется проверка индексов
 * и при переполнении массива, его размер увеличивается динамически
 */

class DynamicArray(private var capacity: Int = 10) {
    private var data = Array(capacity) { 0 }
    private var index = 0

    /**
     * добавляет новый элемент в массив
     *
     * если массив не может вместить новый элемент, то его размер динамически увеличивается
     *
     * @value - элемент
     */
    fun add(value: Int) {
        if (index < data.size - 1) {
            data[index++] = value
        } else {
            increaseSize()
            data[index++] = value
        }
    }

    /**
     * удаляет элемент из массива и сдвигает на его место последующие
     *
     * @value - элемент
     */
    fun remove(value: Int) : Boolean {
        val foundedIndex = data.indexOf(value)
        if (foundedIndex == -1) {
            return false
        }
        for (i in foundedIndex until data.size - 1) {
            data[i] = data[i + 1]
        }
        return true
    }

    /**
     * проверяет на существование элемента в массиве
     *
     * @value - элемент
     *
     * @return возвращает true, если элемент присутствует в массиве
     */
    fun contains(value: Int) = data.contains(value)

    /**
     * устанавливает новое значения элемента для указанного индекса
     *
     * @index - индекс элемента
     * @value - новое значение элемента
     *
     * @return возвращает true, если элемент был успешно изменен
     */
    fun set(index: Int, value: Int) : Boolean {
        if (isBound(index)) {
            data[index] = value
            return true
        }
        return false
    }


    /**
     * возвращает значение элемента по индексу или генерирует исключение, если некорректный индекс
     *
     * @index - индекс элемента
     *
     * @return возвращает значение элемента по индексу
     */
    fun get(index: Int) : Int {
        if (isBound(index)) {
            return data[index]
        } else {
            throw IllegalStateException("index is out of bounds!")
        }
    }

    /**
     * возвращает размер массива
     *
     * @return возвращает размер массива
     */
    fun capacity() = capacity

    /**
     * проверка на корретный индекс
     *
     * @return возвращает true, если индекс входит в диапазон доступных индексов
     */
    private fun isBound(i: Int) = i in 0 until index

    override fun toString() = data.joinToString(", ")

    /**
     * увеличивает размер массива, когда его нехватает
     */
    private fun increaseSize() {
        capacity *= 2
        val newArray = Array(capacity) { 0 }
        for ((index, element) in data.withIndex()) {
            newArray[index] = element
        }
        data = newArray
    }

}