package design_patterns

/**
 *
 * pattern: Visitor
 *
 * description: it's a behavioral pattern that allows you to add a new operation
 * to an entire class hierarchy without changing the code of these classes.
 *
 */

interface PonyVisitor {
    fun visitPonies(vararg ponies: LittlePony) : String
    fun visitEarthPony(pony: EarthPony) : String
    fun visitUnicorn(pony: Unicorn) : String
    fun visitPegasus(pony: Pegasus) : String
}

class JsonVisitor : PonyVisitor {

    override fun visitPonies(vararg ponies: LittlePony) : String {
        val poniesString = ponies.joinToString(",\n") { pony -> pony.accept(this) }
        return "[$poniesString]"
    }

    override fun visitEarthPony(pony: EarthPony): String {
        return """
            {
                "what" : "earth pony",
                "name" : "${pony.name()}",
                "cutie_mark" : "${pony.cutie()}
            }
        """.trimIndent()
    }

    override fun visitUnicorn(pony: Unicorn): String {
        return """
            {
                "what" : "unicorn",
                "name" : "${pony.name()}",
                "cutie_mark" : "${pony.cutie()}
            }
        """.trimIndent()
    }

    override fun visitPegasus(pony: Pegasus): String {
        return """
            {
                "what" : "pegasus",
                "name" : "${pony.name()}",
                "cutie_mark" : "${pony.cutie()}
            }
        """.trimIndent()
    }

}

class XmlVisitor : PonyVisitor {

    override fun visitPonies(vararg ponies: LittlePony) : String {
        val poniesString = ponies.joinToString("\n") { pony -> pony.accept(this) }
        return "<ponies>\n$poniesString\n</ponies>"
    }

    override fun visitEarthPony(pony: EarthPony): String {
        return """
            <pony>
                <what>earth pony</what>
                <name>${pony.name()}</name>
                <cutie_mark>${pony.cutie()}</cutie_mark>
            </pony>
        """.trimIndent()
    }

    override fun visitUnicorn(pony: Unicorn): String {
        return """
            <pony>
                <what>unicorn</what>
                <name>${pony.name()}</name>
                <cutie_mark>${pony.cutie()}</cutie_mark>
            </pony>
        """.trimIndent()
    }

    override fun visitPegasus(pony: Pegasus): String {
        return """
            <pony>
                <what>pegasus</what>
                <name>${pony.name()}</name>
                <cutie_mark>${pony.cutie()}</cutie_mark>
            </pony>
        """.trimIndent()
    }

}

abstract class LittlePony(private val name: String, private val cutieMark: String) {

    fun name() = name
    fun cutie() = cutieMark

    abstract fun accept(visitor: PonyVisitor) : String
}

class EarthPony(name: String, cutieMark: String) : LittlePony(name, cutieMark) {
    override fun accept(visitor: PonyVisitor) = visitor.visitEarthPony(this)
}

class Unicorn(name: String, cutieMark: String) : LittlePony(name, cutieMark) {
    override fun accept(visitor: PonyVisitor) = visitor.visitUnicorn(this)

}

class Pegasus(name: String, cutieMark: String) : LittlePony(name, cutieMark) {
    override fun accept(visitor: PonyVisitor) = visitor.visitPegasus(this)
}

