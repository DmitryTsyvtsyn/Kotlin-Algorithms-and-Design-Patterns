package design_patterns

object LocalData {
    private val names = mutableListOf<String>()

    fun addName(nm: String) {
        names.add(nm)
    }

    fun names() = names.toList()
}