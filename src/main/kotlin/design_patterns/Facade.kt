package design_patterns

/**
 *
 * pattern: Facade
 *
 * using: used to simplify access to an object with a complex implementation
 *
 * description: a complex object contains several dependencies within itself, which it combines with each other
 *
 */


/**
 * imitation of local data storage (database)
 */
class LocalDataSource {

    private val data = mutableListOf<String>()

    fun save(data: List<String>) {
        this.data.addAll(data)
    }

    fun read() = data
    fun isEmpty() = data.isEmpty()

}

/**
 * network request simulation
 */
class NetworkDataSource {
    fun get() = listOf(
        "Harry Potter",
        "Ronald Weasley",
        "Hermione Granger"
    )
}

class Repository(private val localSource: LocalDataSource, private val networkSource: NetworkDataSource) {

    fun fetch() : List<String> {
        // I omitted error handling for simplicity
        if (localSource.isEmpty()) {
            val data = networkSource.get()
            localSource.save(data)
        }
        return localSource.read()
    }

}