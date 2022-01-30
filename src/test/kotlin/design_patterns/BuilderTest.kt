package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class BuilderTest {

    @Test
    fun test() {

        val name = "Twillight Sparkle"
        val cutieMark = "The magic star"
        val city = "Canterlot"
        val family = "Alicorn"

        val pony = Pony.Builder().changeName(name)
            .changeCutieMark(cutieMark)
            .changeCity(city)
            .changeFamily(family)
            .build()

        assertEquals(name, pony.name())
        assertEquals(cutieMark, pony.cutieMark())
        assertEquals(city, pony.city())
        assertEquals(family, pony.family())
    }

}