package design_patterns

/**
 *
 * pattern: Dependency Injection
 *
 * using: used when we have classes that depend on others
 *
 * description: all dependencies (classes that ours depends on) are passed through the constructor
 *
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

class NewsViewModel(repo: NewsRepository) {
    val news = repo.news()
}