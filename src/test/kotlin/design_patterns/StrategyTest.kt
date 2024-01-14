package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class StrategyTest {

    @Test
    fun test() {
        val strategy = OnlyChipsFilterStrategy()
        val foodStore = FoodStore(strategy)

        assertEquals(listOf(
            FoodEntity(
                "Lays Potato Chips Fried Crab Flavor",
                2,
                "chips"
            ),
            FoodEntity(
                "Lay's Potato Chips, Classic",
                3,
                "chips"
            )
        ), foodStore.foodItems())

        foodStore.changeStrategy(OnlyChocolateFilterStrategy())

        assertEquals(listOf(
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
        ), foodStore.foodItems())

        foodStore.changeStrategy(PriceFilterStrategy(3))

        assertEquals(listOf(
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
        ), foodStore.foodItems())

        foodStore.changeStrategy(SearchWordFilterStrategy("Ritter Sport"))

        assertEquals(listOf(
            FoodEntity(
                "Ritter Sport Chocolate",
                4,
                "chocolate"
            )
        ), foodStore.foodItems())
    }

}