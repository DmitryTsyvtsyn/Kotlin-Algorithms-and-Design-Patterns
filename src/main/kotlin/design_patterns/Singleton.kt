package design_patterns

/**
 *
 * pattern: Singleton
 *
 * using: used when we need to have the same object throughout
 * the entire execution of our program
 *
 * description: class allows you to create only a single object
 *
 */

object LocalData {
    private val names = mutableListOf<String>()

    fun addName(nm: String) {
        names.add(nm)
    }

    fun names() = names.toList()
}