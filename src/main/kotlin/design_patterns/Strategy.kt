package design_patterns

/**
 *
 * Strategy is a behavioral design pattern used to define a family of algorithms,
 *
 * encapsulate each one and make them interchangeable
 *
 */

// encapsulates the filtering algorithm
interface FoodFilterStrategy {
    fun filter(items: List<FoodEntity>): List<FoodEntity>
}

class OnlyChipsFilterStrategy : FoodFilterStrategy {
    override fun filter(items: List<FoodEntity>): List<FoodEntity> {
        return items.filter { it.category == "chips" }
    }
}

class OnlyChocolateFilterStrategy : FoodFilterStrategy {
    override fun filter(items: List<FoodEntity>): List<FoodEntity> {
        return items.filter { it.category == "chocolate" }
    }
}

class PriceFilterStrategy(private val price: Int) : FoodFilterStrategy {
    override fun filter(items: List<FoodEntity>): List<FoodEntity> {
        return items.filter { it.price >= price }
    }
}

class SearchWordFilterStrategy(private val search: String) : FoodFilterStrategy {
    override fun filter(items: List<FoodEntity>): List<FoodEntity> {
        return items.filter { it.title.contains(search, ignoreCase = true) }
    }
}

data class FoodEntity(
    val title: String,
    val price: Int,
    val category: String
)

// FoodStore returns a list of food filtered by strategy
class FoodStore(private var filterStrategy: FoodFilterStrategy) {

    // we can change strategy
    fun changeStrategy(strategy: FoodFilterStrategy) {
        filterStrategy = strategy
    }

    fun foodItems(): List<FoodEntity> {
        val foodItems = fetchFoodItems()
        return filterStrategy.filter(foodItems)
    }

    private fun fetchFoodItems() =
        listOf(
            FoodEntity(
                "Lays Potato Chips Fried Crab Flavor",
                2,
                "chips"
            ),
            FoodEntity(
                "Lay's Potato Chips, Classic",
                3,
                "chips"
            ),
            FoodEntity(
                "Dove Chocolate",
                3,
                "chocolate"
            ),
            FoodEntity(
                "Ritter Sport Chocolate",
                4,
                "chocolate"
            )
        )

}

