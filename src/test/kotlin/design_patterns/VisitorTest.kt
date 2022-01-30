package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class VisitorTest {

    private val expectedJson = """
        [{
            "what" : "unicorn",
            "name" : "Twilight Sparkle",
            "cutie_mark" : "star
        },
        {
            "what" : "pegasus",
            "name" : "Rainbow Dash",
            "cutie_mark" : "lightning
        },
        {
            "what" : "earth pony",
            "name" : "Apple Jack",
            "cutie_mark" : "apple
        }]
    """.trimIndent()

    private val expectedXml = """
        <ponies>
        <pony>
            <what>unicorn</what>
            <name>Twilight Sparkle</name>
            <cutie_mark>star</cutie_mark>
        </pony>
        <pony>
            <what>pegasus</what>
            <name>Rainbow Dash</name>
            <cutie_mark>lightning</cutie_mark>
        </pony>
        <pony>
            <what>earth pony</what>
            <name>Apple Jack</name>
            <cutie_mark>apple</cutie_mark>
        </pony>
        </ponies>
    """.trimIndent()

    @Test
    fun test_json_visitor() {
        val jsonVisitor = JsonVisitor()
        val twilightSparkle = Unicorn("Twilight Sparkle", "star")
        val rainbowDash = Pegasus("Rainbow Dash", "lightning")
        val appleJack = EarthPony("Apple Jack", "apple")
        val actual = jsonVisitor.visitPonies(twilightSparkle, rainbowDash, appleJack)
        assertEquals(expectedJson, actual)
    }

    @Test
    fun test_xml_visitor() {
        val xmlVisitor = XmlVisitor()
        val twilightSparkle = Unicorn("Twilight Sparkle", "star")
        val rainbowDash = Pegasus("Rainbow Dash", "lightning")
        val appleJack = EarthPony("Apple Jack", "apple")
        val actual = xmlVisitor.visitPonies(twilightSparkle, rainbowDash, appleJack)
        assertEquals(expectedXml, actual)
    }

}