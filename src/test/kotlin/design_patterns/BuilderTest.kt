package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class BuilderTest {

    @Test
    fun test_first_variant() {

        val name = "Twillight Sparkle"
        val cutieMark = "The magic star"
        val city = "Canterlot"
        val family = "Alicorn"

        val pony = Pony1.Builder().changeName(name)
            .changeCutieMark(cutieMark)
            .changeCity(city)
            .changeFamily(family)
            .build()

        assertEquals(name, pony.name())
        assertEquals(cutieMark, pony.cutieMark())
        assertEquals(city, pony.city())
        assertEquals(family, pony.family())
    }

    @Test
    fun test_the_second_variant() {

        val name = "Twillight Sparkle"
        val cutieMark = "The magic star"
        val city = "Canterlot"
        val family = "Alicorn"

        val pony = Pony2.newBuilder().changeName(name)
            .changeCutieMark(cutieMark)
            .changeCity(city)
            .changeFamily(family)
            .build()

        assertEquals(name, pony.name())
        assertEquals(cutieMark, pony.cutieMark())
        assertEquals(city, pony.city())
        assertEquals(family, pony.family())
    }

    @Test
    fun test_third_variant() {

        val name = "Twillight Sparkle"
        val city = "Canterlot"
        val family = "Alicorn"

        val pony = Pony3(name, family, city = city)

        assertEquals(name, pony.name())
        assertEquals("", pony.cutieMark())
        assertEquals(city, pony.city())
        assertEquals(family, pony.family())
    }



}