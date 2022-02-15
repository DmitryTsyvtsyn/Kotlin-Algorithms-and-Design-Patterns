package design_patterns

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class FactoryMethodTest {

    @Test
    fun test_match_objects() {
        val ponyville = Ponyville()
        val earthPony = ponyville.newPony()

        assertThat(earthPony, instanceOf(EarthPony4::class.java))

        val canterlot = Canterlot()
        val unicorn = canterlot.newPony()

        assertThat(unicorn, instanceOf(Unicorn4::class.java))
    }

    @Test
    fun test_count() {
        val cloudsDale = Cloudsdale()

        cloudsDale.newPony()
        cloudsDale.newPony()
        cloudsDale.newPony()

        assertEquals(3, cloudsDale.count())
    }
}