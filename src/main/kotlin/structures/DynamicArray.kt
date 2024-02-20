package structures

import java.lang.IllegalStateException

/**
 *
 * Dynamic array or array list is a random access, variable-size list data structure
 *
 * that allows elements to be added or removed, in Java this is java.util.ArrayList
 *
 * P.S. Kotlin lists use under the hood java.util.ArrayList on the JVM
 * 
 * Example:
 *
 * 1) val numbers = listOf(1, 2, 3) // java.util.ArrayList
 *
 * 2) val symbols = mutableListOf('a', 'b', 'c') // also java.util.ArrayList
 *     
 */

class DynamicArray<T>(private var capacity: Int = 10) {

    private var data = arrayOfNulls<Any>(capacity)
    private var size = 0

    /**
     * Complexity:
     * worst time - O(n) because increaseSize() is called
     * best time - O(1)
     * average time - O(1)
     */
    fun add(value: T) {
        if (size <= data.size - 1) {
            data[size] = value
        } else {
            increaseSize()
            data[size] = value
        }
        size += 1
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(n)
     * average time: O(n)
     */
    fun remove(value: T) : Boolean {
        var foundedIndex = -1

        for (i in data.indices) {
            if (data[i] == value) {
                foundedIndex = i
                break
            }
        }

        if (foundedIndex == -1) return false

        for (i in foundedIndex until data.size - 1) {
            data[i] = data[i + 1]
        }

        size -= 1

        return true
    }

    /**
     * Complexity:
     * worst time: O(n)
     * best time: O(1)
     * average time: O(n)
     */
    fun contains(value: T): Boolean {
        for (i in data.indices) {
            if (data[i] == value) {
                return true
            }
        }

        return false
    }

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun set(index: Int, value: T): T? {
        if (index !in 0 until size) throw IllegalStateException("The index $index is out of bounds!")

        val oldValue = data[index]

        data[index] = value

        return oldValue as? T
    }

    /**
     * Complexity:
     * worst time: O(1)
     * best time: O(1)
     * average time: O(1)
     */
    fun get(index: Int) : T {
        if (index !in data.indices) throw IllegalStateException("The index $index is out of bounds!")

        return data[index] as T
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("capacity: $capacity\n")
        builder.append("size: $size\n")

        builder.append("elements: ")
        for (i in 0 until size - 1) {
            builder.append("${data[i]}, ")
        }
        builder.append(data[size - 1])

        return builder.toString()
    }

    private fun increaseSize() {
        capacity = (capacity * INCREASE_SIZE_COEFFICIENT).toInt()
        val newArray = arrayOfNulls<Any>(capacity)
        for (i in data.indices) {
            newArray[i] = data[i]
        }
        data = newArray
    }

    companion object {
        private const val INCREASE_SIZE_COEFFICIENT = 1.5f
    }

}