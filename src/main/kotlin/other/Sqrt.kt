package other

/**
 * поиск квадратного корня из числа
 * по алгоритму из википедии https://shorturl.at/pvAQ7
 */
class Sqrt {

    /**
     * возвращает корень из числа
     * @number - число, корень которого нужно найти
     */
    fun compute(number: Double) : Double {
        var value = number / 2
        for (i in 1..100) {
            value = (value + number / value) / 2
        }
        return value
    }

}