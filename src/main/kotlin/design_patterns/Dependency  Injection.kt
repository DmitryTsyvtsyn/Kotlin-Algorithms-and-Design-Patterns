package design_patterns

/**
 * паттерн Dependency Injection
 *
 * мы создаем зависимости снаружи и предоставляем их через конструкторы
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