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

abstract class House(private val address: String, private val price: Int) {

    override fun toString() = """
        address = $address
        price = $price
    """.trimIndent()

}

// the factory method makes sense if we have a hierarchy of objects
class WoodenCheapHouse(address: String) : House(address, 50_000)
class WoodenAverageHouse(address: String) : House(address, 250_000)
class WoodenExpensiveHouse(address: String) : House(address, 1_000_000)

class StoneCheapHouse(address: String) : House(address, 45_000)
class StoneAverageHouse(address: String) : House(address, 230_000)
class StoneExpensiveHouse(address: String) : House(address, 900_000)

// we have a common logic for every HouseCompany
abstract class HouseCompany {

    private val alreadyBuiltHouses = mutableListOf<House>()

    val examplesAlreadyBuiltHouses: String
        get() = alreadyBuiltHouses.joinToString("\n\n")

    fun orderHouse(address: String, cost: HouseCompanyCost): House {
        val house = buildHouse(address, cost)
        alreadyBuiltHouses.add(house)
        return house
    }

    // the subclasses define a specific implementation
    protected abstract fun buildHouse(address: String, cost: HouseCompanyCost): House

    enum class HouseCompanyCost { CHEAP, AVERAGE, EXPENSIVE }

}

// WoodenHouseCompany only builds wooden houses
class WoodenHouseCompany : HouseCompany() {

    override fun buildHouse(address: String, cost: HouseCompanyCost) = when(cost) {
        HouseCompanyCost.CHEAP -> WoodenCheapHouse(address)
        HouseCompanyCost.AVERAGE -> WoodenAverageHouse(address)
        HouseCompanyCost.EXPENSIVE -> WoodenExpensiveHouse(address)
    }

}

// StoneHouseCompany only builds stone houses
class StoneHouseCompany : HouseCompany() {

    override fun buildHouse(address: String, cost: HouseCompanyCost) = when(cost) {
        HouseCompanyCost.CHEAP -> StoneCheapHouse(address)
        HouseCompanyCost.AVERAGE -> StoneAverageHouse(address)
        HouseCompanyCost.EXPENSIVE -> StoneExpensiveHouse(address)
    }

}