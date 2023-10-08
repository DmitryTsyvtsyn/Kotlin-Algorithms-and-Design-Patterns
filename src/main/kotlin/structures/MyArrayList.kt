package structures

import java.lang.IllegalStateException

/**
 *
 * data structure: simple java.util.ArrayList implementation
 *
 * description: wrapper over a regular array, in which indexes are checked and
 * when the array overflows, its size increases dynamically
 *
 * @property capacity initial array size
 *
 * P.S. Kotlin lists use under the hood java.util.ArrayList
 * for example:
 *     val numbers = listOf(1, 2, 3) // java.util.ArrayList
 *     val symbols = mutableListOf('a', 'b', 'c') // also java.util.ArrayList
 */

class MyArrayList(private var capacity: Int = 10) {
    private var data = Array(capacity) { 0 }
    private var index = 0

    /**
     * adds a new element [value] in array, if the array cannot accommodate the new element, then its size is dynamically increased
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
     * removes an element [value] from the array and shifts subsequent elements in its place
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
     * checks for the existence of an element [value] in an array, returns true if the element is present in the array
     */
    fun contains(value: Int) = data.contains(value)

    /**
     * sets the new element [value] at the specified index [index], returns true if the element was successfully modified
     */
    fun set(index: Int, value: Int) : Boolean {
        if (isBound(index)) {
            data[index] = value
            return true
        }
        return false
    }

    /**
     * returns the value of the element by index [index], or throws an exception if the index is invalid
     */
    fun get(index: Int) : Int {
        if (isBound(index)) {
            return data[index]
        } else {
            throw IllegalStateException("index is out of bounds!")
        }
    }

    /**
     * returns the size of the array
     */
    fun capacity() = capacity

    /**
     * checks for correct index, returns true if the index is within the range of available indexes
     */
    private fun isBound(i: Int) = i in 0 until index

    override fun toString() = data.joinToString(", ")

    /**
     * increases the size of an array when there is not enough to add new elements
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