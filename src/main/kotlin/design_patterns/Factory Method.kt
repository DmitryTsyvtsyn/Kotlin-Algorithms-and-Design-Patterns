package design_patterns

/**
 *
 * A factory method is a generic design pattern that defines
 *
 * a common interface for creating objects in a superclass,
 *
 * allowing subclasses to change the type of objects they create.
 *
 */

abstract class Pony4

class EarthPony4 : Pony4()
class Pegasus4 : Pony4()
class Unicorn4 : Pony4()

abstract class Place {
    private var numberOfPonies = 0

    abstract fun pony() : Pony4

    fun newPony() : Pony4 {
        numberOfPonies++
        return pony()
    }

    fun count() = numberOfPonies
}

class Cloudsdale : Place() {
    override fun pony() = Pegasus4()
}

class Canterlot : Place() {
    override fun pony() = Unicorn4()
}

class Ponyville : Place() {
    override fun pony() = EarthPony4()
}