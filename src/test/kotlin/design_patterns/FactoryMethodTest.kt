package design_patterns

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Test

class FactoryMethodTest {

    @Test
    fun `test WoodenHouseCompany`() {
        val woodenHouseCompany = WoodenHouseCompany()

        val house1 = woodenHouseCompany.orderHouse("77, Brook Ave", HouseCompany.HouseCompanyCost.CHEAP)
        assertThat(house1, instanceOf(WoodenCheapHouse::class.java))

        val house2 = woodenHouseCompany.orderHouse("77, Brook Ave", HouseCompany.HouseCompanyCost.AVERAGE)
        assertThat(house2, instanceOf(WoodenAverageHouse::class.java))

        val house3 = woodenHouseCompany.orderHouse("77, Brook Ave", HouseCompany.HouseCompanyCost.EXPENSIVE)
        assertThat(house3, instanceOf(WoodenExpensiveHouse::class.java))

        val expected = """
            address = 77, Brook Ave
            price = 50000
            
            address = 77, Brook Ave
            price = 250000
            
            address = 77, Brook Ave
            price = 1000000
        """.trimIndent()
        assertEquals(expected, woodenHouseCompany.examplesAlreadyBuiltHouses)
    }

    @Test
    fun `test StoneHouseCompany`() {
        val stoneHouseCompany = StoneHouseCompany()

        val house1 = stoneHouseCompany.orderHouse("55, Brook Ave", HouseCompany.HouseCompanyCost.CHEAP)
        assertThat(house1, instanceOf(StoneCheapHouse::class.java))

        val house2 = stoneHouseCompany.orderHouse("55, Brook Ave", HouseCompany.HouseCompanyCost.AVERAGE)
        assertThat(house2, instanceOf(StoneAverageHouse::class.java))

        val house3 = stoneHouseCompany.orderHouse("55, Brook Ave", HouseCompany.HouseCompanyCost.EXPENSIVE)
        assertThat(house3, instanceOf(StoneExpensiveHouse::class.java))

        val expected = """
            address = 55, Brook Ave
            price = 45000
            
            address = 55, Brook Ave
            price = 230000
            
            address = 55, Brook Ave
            price = 900000
        """.trimIndent()
        assertEquals(expected, stoneHouseCompany.examplesAlreadyBuiltHouses)
    }

}