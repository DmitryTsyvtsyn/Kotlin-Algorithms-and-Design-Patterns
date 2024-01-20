package design_patterns

/**
 *
 * Flyweight is a structural design pattern that reduces memory costs by reusing a family of objects
 *
 * and storing mutable state outside the object.
 *
 */

class BeautifulGarden {

    // we reuse objects with immutable state, in this example trees
    private val existingTrees = mutableListOf<Tree>()

    // mutable state (coordinates) are stored outside the object
    private val placedTrees = mutableListOf<Triple<Int, Int, Tree>>()

    fun placeTree(name: String, description: String, height: Int, x: Int, y: Int) {
        // check if such a tree already exists reuse it otherwise create a new one
        val tree = existingTrees.find { tree -> tree.name == name && tree.description == description && tree.height == height }
            ?: Tree(name, description, height).apply(existingTrees::add)

        placedTrees.add(Triple(x, y, tree))
    }

    fun placedTreesAsString(): String {
        val builder = StringBuilder()
        builder.append("Beautiful Garden:\n")

        placedTrees.forEach { (x, y, tree) ->
            builder.append("name: ${tree.name}, height: ${tree.height}, x: $x, y: $y\n")
        }

        builder.append("-|-|-|-|-|-|-|-|-|-|-")

        return builder.toString()
    }

    data class Tree(
        val name: String,
        val description: String,
        val height: Int
    )

}