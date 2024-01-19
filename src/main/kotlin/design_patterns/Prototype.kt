package design_patterns

/**
 *
 * Prototype is a generative design pattern that allows you to copy objects
 *
 * without going into the details of their implementation.
 *
 */

abstract class Sweets(
    protected val title: String,
    protected val description: String,
    protected val price: Int
) {

    // we only have a copy interface and don't know about its implementation
    abstract fun copy(): Sweets

}

class OreoCookies(
    title: String,
    private val flavor: String,
    price: Int
) : Sweets(
    title = title,
    price = price,
    description = "Take a delicious break with OREO Chocolate Sandwich Cookies, America's favorite sandwich cookie for over 100 years..."
) {

    // each implementation creates its own copy
    override fun copy(): Sweets {
        return OreoCookies(title, flavor, price)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this === other) return true
        if (other !is OreoCookies) return false

        return title == other.title && description == other.description &&
                flavor == other.flavor && price == other.price
    }

}

class `M&MsChocolate`(
    private val taste: String,
    price: Int,
) : Sweets(
    title = "M&M's chocolate",
    price = price,
    description = "M&M's are a chocolate jelly bean produced by Mars LLC. It first appeared in the United States in 1941 and is now sold in more than 100 countries..."
) {

    override fun copy(): Sweets {
        return `M&MsChocolate`(taste, price)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this === other) return true
        if (other !is `M&MsChocolate`) return false

        return title == other.title && description == other.description &&
                taste == other.taste && price == other.price
    }

}

