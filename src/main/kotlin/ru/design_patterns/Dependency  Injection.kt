package ru.design_patterns

/**
 * название: паттерн Dependency Injection
 *
 * применение: используется когда у нас есть классы, которые зависят от других
 *
 * описание: все зависимости (классы, от которых зависит наш) передаются через конструктор
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