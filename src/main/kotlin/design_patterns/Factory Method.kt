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

abstract class Pony

class EarthPony4 : Pony()
class Pegasus4 : Pony()
class Unicorn4 : Pony()

abstract class Place {
    private var numberOfPonies = 0

    abstract fun pony() : Pony

    fun newPony() : Pony {
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