package structures

import java.lang.IllegalArgumentException

fun matrix(apply: Matrix.() -> Unit): Matrix {
    val matrix = Matrix()
    matrix.apply()
    return matrix
}

/**
 * Matrix is a rectangular table filled with numbers.
 *
 * For example:
 *   1, 2, 3
 *   4, 5, 6
 *   7, 8, 9
 */
class Matrix() {

    private val elements = mutableListOf<Int>()
    private var columnCount = 0
    private var rowCount = 0

    private constructor(elements: List<Int>, columnCount: Int, rowCount: Int) : this() {
        this.elements.addAll(elements)
        this.columnCount = columnCount
        this.rowCount = rowCount
    }

    fun row(vararg rowElements: Int) {
        if (rowElements.isEmpty()) {
            return
        }

        if (rowCount == 0) {
            columnCount = rowElements.size
        }

        if (columnCount != rowElements.size) {
            throw IllegalArgumentException("The number of elements in each row must be the same")
        }

        elements.addAll(rowElements.toTypedArray())

        rowCount++
    }

    operator fun plus(value: Int): Matrix {
        return Matrix(elements.map { it + value }, columnCount, rowCount)
    }

    operator fun plus(value: Matrix): Matrix {
        if (rowCount != value.rowCount) throw IllegalArgumentException("The number of rows doesn't match")
        if (columnCount != value.columnCount) throw IllegalArgumentException("The number of columns doesn't match")

        return Matrix(elements.zip(value.elements) { element1, element2 -> element1 + element2 }, columnCount, rowCount)
    }

    operator fun minus(value: Int): Matrix {
        return Matrix(elements.map { it - value }, columnCount, rowCount)
    }

    operator fun minus(value: Matrix): Matrix {
        if (rowCount != value.rowCount) throw IllegalArgumentException("The number of rows doesn't match")
        if (columnCount != value.columnCount) throw IllegalArgumentException("The number of columns doesn't match")

        return Matrix(elements.zip(value.elements) { element1, element2 -> element1 - element2 }, columnCount, rowCount)
    }

    operator fun times(value: Int): Matrix {
        return Matrix(elements.map { it * value }, columnCount, rowCount)
    }

    operator fun div(value: Int): Matrix {
        return Matrix(elements.map { it / value }, columnCount, rowCount)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Matrix) return false
        if (this === other) return true

        return columnCount == other.columnCount && rowCount == other.rowCount && elements == other.elements
    }

    override fun hashCode(): Int {
        var result = elements.hashCode()
        result = 31 * result + columnCount
        result = 31 * result + rowCount
        return result
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder("\n")

        elements.forEachIndexed { index, value ->
            val floating = if ((index + 1) % columnCount == 0) "" else ", "
            stringBuilder.append("$value$floating")

            if ((index + 1) % columnCount == 0) {
                stringBuilder.append("\n")
            }
        }

        return stringBuilder.toString()
    }

}