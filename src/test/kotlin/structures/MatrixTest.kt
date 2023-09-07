package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions
import java.lang.IllegalArgumentException

class MatrixTest {

    @Test
    fun `test when number of elements in each row is not the same`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            matrix {
                row(1, 2, 3)
                row(4, 5)
            }
        }
    }

    @Test
    fun `test equals`() {
        val matrix1 = matrix {
            row(1, 2, 3)
            row(4, 5, 6)
            row(7, 8, 9)
        }

        val matrix2 = matrix {
            row(1, 2, 3)
            row(4, 5, 6)
            row(7, 8, 9)
        }

        Assertions.assertEquals(true, matrix1 == matrix2)

        val matrix3 = matrix {
            row(1, 2, 3)
            row(4, 5, 6)
        }

        Assertions.assertEquals(false, matrix2 == matrix3)
    }

    @Test
    fun `test plus minus a value`() {
        val matrix1 = matrix {
            row(4, 7, 2)
            row(10, 12, 20)
            row(100, 1000, 8)
        }

        val expected1 = matrix {
            row(6, 9, 4)
            row(12, 14, 22)
            row(102, 1002, 10)
        }
        val actual1 = matrix1 + 2

        Assertions.assertEquals(expected1, actual1)

        val actual2 = matrix1 - 10

        val expected2 = matrix {
            row(-6, -3, -8)
            row(0, 2, 10)
            row(90, 990, -2)
        }
        Assertions.assertEquals(expected2, actual2)
    }

    @Test
    fun `test multiply and div by value`() {
        val matrix1 = matrix {
            row(2, 5)
            row(10, 19)
        }

        val expected1 = matrix {
            row(4, 10)
            row(20, 38)
        }
        val actual1 = matrix1 * 2

        Assertions.assertEquals(expected1, actual1)

        val matrix2 = matrix {
            row(100, -95, 1200)
            row(55, 110, -20)
            row(5, 2, -10)
        }

        val actual2 = matrix2 / 5

        val expected2 = matrix {
            row(20, -19, 240)
            row(11, 22, -4)
            row(1, 0, -2)
        }
        Assertions.assertEquals(expected2, actual2)
    }

    @Test
    fun `test plus between matrices`() {
        val matrix1 = matrix {
            row(13, 109)
            row(8, 6)
        }

        val matrix2 = matrix {
            row(9, 34, 2)
            row(90, 20, 1005)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            matrix1 + matrix2
        }

        val matrix3 = matrix {
            row(20, 30)
            row(3, 56)
            row(5, 28)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            matrix1 + matrix3
        }

        val matrix4 = matrix {
            row(7, 1)
            row(2, 4)
        }

        val expected = matrix {
            row(20, 110)
            row(10, 10)
        }

        val actual = matrix1 + matrix4

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `test minus between matrices`() {
        val matrix1 = matrix {
            row(13, 109)
            row(8, 6)
        }

        val matrix2 = matrix {
            row(9, 34, 2)
            row(90, 20, 1005)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            matrix1 - matrix2
        }

        val matrix3 = matrix {
            row(20, 30)
            row(3, 56)
            row(5, 28)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            matrix1 - matrix3
        }

        val matrix4 = matrix {
            row(3, 9)
            row(8, 6)
        }

        val expected = matrix {
            row(10, 100)
            row(0, 0)
        }

        val actual = matrix1 - matrix4

        Assertions.assertEquals(expected, actual)
    }

}