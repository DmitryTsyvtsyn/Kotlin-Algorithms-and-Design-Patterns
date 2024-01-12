package design_patterns

/**
 *
 * Composite is a structural design pattern that organizes objects into a tree structure
 *
 * and allows clients to access individual objects and groups of objects in the same way.
 *
 */

// all components have a common interface
abstract class MenuComponent(val title: String) {
    // menus and items can give information about themselves
    abstract fun fetchMenuInformation() : String
}

class Menu(title: String) : MenuComponent(title) {

    // menu can contain other menus and items
    private val childMenuComponents = mutableListOf<MenuComponent>()

    // addComponent/removeComponent operations are only available for the menu
    fun addComponent(component: MenuComponent) {
        childMenuComponents.add(component)
    }

    fun removeComponent(component: MenuComponent) {
        childMenuComponents.remove(component)
    }

    override fun fetchMenuInformation(): String {
        val builder = StringBuilder()
        builder.append("Menu: $title")
        childMenuComponents.forEach { component ->
            builder.append("\n")
            builder.append(component.fetchMenuInformation())
        }
        return builder.toString()
    }

}

// the simple component that contains no others
class MenuItem(title: String, private val price: Int) : MenuComponent(title) {

    override fun fetchMenuInformation(): String =
        """
            title: $title
            price: $price
            -------------
        """.trimIndent()

}