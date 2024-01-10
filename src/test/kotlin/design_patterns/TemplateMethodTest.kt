package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class TemplateMethodTest {

    @Test
    fun `test ChocolateCakeBaker`() {
        val baker = ChocolateCakeBaker()

        val actual = baker.makeCake(3)
        val expected = Cake(
            layers = listOf(
                "chocolate cake layer",
                "chocolate cake layer",
                "chocolate cake layer"
            ),
            cream = "chocolate cream",
            sprinkles = "chocolate chips"
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `test WaffleCakeBaker`() {
        val baker = WaffleCakeBaker()

        val actual = baker.makeCake(3)
        val expected = Cake(
            layers = listOf(
                "waffle cake layer",
                "waffle cake layer",
                "waffle cake layer"
            ),
            cream = "custard cream",
            sprinkles = "coconut flakes"
        )

        assertEquals(expected, actual)
    }

}