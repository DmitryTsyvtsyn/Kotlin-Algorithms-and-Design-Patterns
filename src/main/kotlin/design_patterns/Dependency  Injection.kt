package design_patterns

/**
 * Название: паттерн Dependency Injection
 * Применение: используется когда у нас есть классы, которые зависят от других
 * Сущность: все зависимости (классы, от которых зависит наш) передаются через конструктор
 */

class NewsApiService {
    fun fetchNews() = listOf(
        "event 1",
        "event 2",
        "event 3"
    )
}

class NewsRepository(private val service: NewsApiService) {
    fun news() = service.fetchNews()
}

class NewsViewModel(private val repo: NewsRepository) {
    val news = repo.news()
}