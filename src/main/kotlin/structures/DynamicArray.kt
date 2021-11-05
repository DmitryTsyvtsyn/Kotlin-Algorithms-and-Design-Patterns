package structures

import java.lang.IllegalStateException

/**
 * структура данных динамический массив
 *
 */

class DynamicArray(private var capacity: Int = 10) {
    private var data = Array(capacity) { 0 }
    private var index = 0

    fun add(value: Int) {
        if (index < data.size - 1) {
            data[index++] = value
        } else {
            increaseSize()
            data[index++] = value
        }
    }

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

    fun contains(value: Int) = data.contains(value)

    fun set(index: Int, value: Int) : Boolean {
        if (isBound(index)) {
            data[index] = value
            return true
        }
        return false
    }

    fun get(index: Int) : Int {
        if (isBound(index)) {
            return data[index]
        } else {
            throw IllegalStateException("index is out of bounds!")
        }
    }

    fun capacity() = capacity

    private fun isBound(index: Int) = index >= 0 && index < data.size

    override fun toString() = data.joinToString(", ")

    private fun increaseSize() {
        capacity *= 2
        val newArray = Array(capacity) { 0 }
        for ((index, element) in data.withIndex()) {
            newArray[index] = element
        }
        data = newArray
    }

}