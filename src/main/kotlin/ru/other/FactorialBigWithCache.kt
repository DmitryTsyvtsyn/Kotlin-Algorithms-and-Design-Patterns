package ru.other

import java.math.BigInteger

/**
 * Алгоритм нахождение факториала положительного числа n
 *
 * Оптимизация: кэширование предыдущих значений факториала
 *
 * Тажке добавление больших чисел
 */

class FactorialBigWithCache {

    private val cache = hashMapOf<Int, BigInteger>()

    /**
     * возвращает факториал числа
     *
     * худшее время: O(n)
     * лучшее время: O(1)
     * количество памяти: O(n)
     * проблема: создание огромного количества объектов BigInteger
     *
     * @number - положительное число
     */
    fun compute(number: Int) : BigInteger {
        if (number <= 1) {
            return BigInteger.ONE
        }

        if (cache.contains(number)) {
            return cache[number]!!
        }

        var result = BigInteger.ONE
        for (i in 2..number) {
            result = result.multiply(i.toBigInteger())
            cache[i] = result
        }
        return result
    }

}