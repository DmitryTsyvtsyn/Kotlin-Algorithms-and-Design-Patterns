package design_patterns

/**
 *
 * Template method a behavioral design pattern that defines the basis of an algorithm
 *
 * and allows subclasses to redefine some steps of the algorithm without changing its overall structure
 *
 */

data class Cake(
    val layers: List<String>,
    val cream: String,
    val sprinkles: String
)

abstract class CakeBaker {

    protected abstract fun layer(): String

    protected abstract fun cream(): String

    protected abstract fun sprinkles(): String

    // we have the basis of an algorithm
    fun makeCake(numberOfLayers: Int): Cake {
        return Cake(
            layers = List(numberOfLayers) { layer() },
            cream = cream(),
            sprinkles = sprinkles()
        )
    }

}

class ChocolateCakeBaker : CakeBaker() {

    // subclasses redefines some steps of the algorithm
    override fun cream(): String = "chocolate cream"

    override fun layer(): String = "chocolate cake layer"

    override fun sprinkles(): String = "chocolate chips"

}

class WaffleCakeBaker : CakeBaker() {

    override fun cream(): String = "custard cream"

    override fun layer(): String = "waffle cake layer"

    override fun sprinkles(): String = "coconut flakes"

}