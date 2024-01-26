package other

import org.junit.Test
import org.junit.Assert.assertEquals

internal class SieveOfEratosthenesAlgorithmTest {

    private val eratosthenesAlgorithm = SieveOfEratosthenesAlgorithm()

    @Test
    fun tes() {
        assertEquals(emptyList<Int>(), eratosthenesAlgorithm.compute(1))
        assertEquals(listOf(2, 3, 5, 7), eratosthenesAlgorithm.compute(10))
        assertEquals(listOf(2, 3, 5, 7, 11, 13, 17, 19), eratosthenesAlgorithm.compute(20))
        assertEquals(listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37), eratosthenesAlgorithm.compute(40))
        assertEquals(
            listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101),
            eratosthenesAlgorithm.compute(102)
        )
        assertEquals(
            listOf(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
                103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
                211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293
            ),
            eratosthenesAlgorithm.compute(300)
        )
    }

}