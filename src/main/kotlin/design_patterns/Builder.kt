package design_patterns

/**
 *
 * pattern: Builder
 *
 * using: used to create complex objects
 *
 * description: to create an object, an auxiliary class Builder is used, which has methods for changing the fields of our main class.
 *
 */


/**
 *
 * The first variant
 *
 */

class Pony1 {
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

    override fun toString(): String {
        return "$name, $family, $cutieMark, $city"
    }

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

        fun build() = Pony1(name, family, cutieMark, city)

    }

}

/**
 *
 * The second variant
 *
 */

class Pony2 {
    private var name: String = ""
    private var family: String = ""
    private var cutieMark: String = ""
    private var city: String = ""

    override fun toString(): String {
        return "$name, $family, $cutieMark, $city"
    }

    companion object {
        fun newBuilder() = Pony2().Builder()
    }

    inner class Builder {

        fun changeName(name: String) = apply {
            this@Pony2.name = name
        }

        fun changeFamily(family: String) = apply {
            this@Pony2.family = family
        }

        fun changeCutieMark(cutieMark: String) = apply {
            this@Pony2.cutieMark = cutieMark
        }

        fun changeCity(city: String) = apply {
            this@Pony2.city = city
        }

        fun build() = this@Pony2
    }

}

/**
 *
 * Kotlin variant with default arguments
 *
 */

class Pony3(
    private var name: String = "",
    private var family: String = "",
    private var cutieMark: String = "",
    private var city: String = ""
) {
    override fun toString(): String {
        return "$name, $family, $cutieMark, $city"
    }
}