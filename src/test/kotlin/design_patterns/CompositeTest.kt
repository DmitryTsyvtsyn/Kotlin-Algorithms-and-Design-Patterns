package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class CompositeTest {

    @Test
    fun test() {
        val menu = Menu("Delicious Restaurant")

        val pizzasMenu = Menu("Pizzas")
        pizzasMenu.addComponent(MenuItem("Cheese pizza", 10))
        pizzasMenu.addComponent(MenuItem("Pepperoni pizza", 11))
        menu.addComponent(pizzasMenu)

        val cakesMenu = Menu("Cakes")
        cakesMenu.addComponent(MenuItem("Chocolate cake", 13))
        cakesMenu.addComponent(MenuItem("Cheese cake", 13))
        menu.addComponent(cakesMenu)

        assertEquals("""
            Menu: Delicious Restaurant
            Menu: Pizzas
            title: Cheese pizza
            price: 10
            -------------
            title: Pepperoni pizza
            price: 11
            -------------
            Menu: Cakes
            title: Chocolate cake
            price: 13
            -------------
            title: Cheese cake
            price: 13
            -------------
        """.trimIndent(), menu.fetchMenuInformation())
    }

}