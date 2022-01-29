package ru.other

/**
 * Алгоритм нахождение факториала положительного числа n
 *
 * Оптимизация: кэширование предыдущих значений факториала
 */

class FactorialWithCache {

    private val cache = hashMapOf<Int, Int>()

    /**
     * возвращает факториал числа
     *
     * худшее время: O(n)
     * лучшее время: O(1)
     * количество памяти: O(n)
     *
     * @number - положительное число
     */
    fun compute(number: Int) : Int {
        if (number <= 1) {
            return 1
        }

        if (cache.contains(number)) {
            return cache[number]!!
        }

        var result = 1
        for (i in 2..number) {
            result *= i
            cache[i] = result
        }
        return result
    }

}