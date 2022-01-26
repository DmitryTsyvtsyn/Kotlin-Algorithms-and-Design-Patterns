package en.other

/**
 * Алгоритм нахождение факториала положительного числа n
 */

class Factorial {

    /**
     * возвращает факториал числа итеративным методом
     *
     * худшее время: O(n)
     * количество памяти: O(1)
     *
     * @number - положительное число
     */
    fun compute(number: Int) : Int {
        var result = 1
        for (i in 1..number) {
           result *= i
        }
        return result
    }

    /**
     * возвращает факториал числа рекурсивным методом
     *
     * худшее время: O(n)
     * количество памяти: O(n) - стэк для рекурсии
     *
     * @number - положительное число
     */
    fun computeRecursive(number: Int) : Int {
        return if (number <= 1) {
            1
        } else {
            number * computeRecursive(number - 1)
        }
    }

}