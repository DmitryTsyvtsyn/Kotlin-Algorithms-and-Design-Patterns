package ru.design_patterns

/**
 * название: паттерн Facade
 *
 * применение: используется для упрощения доступа к объекту со сложной реализацией
 *
 * описание: сложный объект содержит внутри себя несколько зависимостей, который он комбинирует между собой
 */

/**
 * имитация локального хранилища данных (база данных)
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
 * имитация запроса к сети
 */
class NetworkDataSource {
    fun get() = listOf(
        "Harry Potter",
        "Ronald Weasley",
        "Hermione Granger"
    )
}

/**
 * имитация репозитория данных
 */
class Repository(private val localSource: LocalDataSource, private val networkSource: NetworkDataSource) {

    fun fetch() : List<String> {
        // я опустил обработку ошибок для простоты
        if (localSource.isEmpty()) {
            val data = networkSource.get()
            localSource.save(data)
        }
        return localSource.read()
    }

}