package design_patterns

class Pony {
    private val name: String
    private val family: String
    private val cutieMark: String
    private val city: String

    private constructor(name: String, family: String, cutieMark: String, city: String) {
        this.name = name
        this.family = family
        this.cutieMark = cutieMark
        this.city = city
    }

    fun name() = name
    fun family() = family
    fun cutieMark() = cutieMark
    fun city() = city

    class Builder {
            private var name: String = ""
            private var family: String = ""
            private var cutieMark: String = ""
            private var city: String = ""

            fun changeName(name: String) = apply {
                this.name = name
            }

            fun changeFamily(family: String) = apply {
                this.family = family
            }

            fun changeCutieMark(cutieMark: String) = apply {
                this.cutieMark = cutieMark
            }

            fun changeCity(city: String) = apply {
                this.city = city
            }

            fun build() = Pony(name, family, cutieMark, city)

    }

}