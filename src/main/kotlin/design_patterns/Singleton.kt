package design_patterns

/**
 * Название: паттерн Singleton
 * Применение: используется в тех случаях, когда нам нужно иметь один и тот же объект
 * на протяжении всего времени выполнения нашей программы
 * Сущность: класс позволяет создать только единственный объект
 */

object LocalData {
    private val names = mutableListOf<String>()

    fun addName(nm: String) {
        names.add(nm)
    }

    fun names() = names.toList()
}