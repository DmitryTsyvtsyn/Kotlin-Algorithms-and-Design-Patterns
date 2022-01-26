package en.other

/**
 * простейшая игра FizzBuzz
 *
 * описание: игрок последовательно говорит числа при условии:
 *  - если число делится на 3, он говорит Fizz
 *  - если число делится на 5, он говорит Buzz
 *  - если число делится и на 3 и на 5, он говорит FizzBuzz
 *  - иначе, игрок называет само число
 */

class FizzBuzz {

    /**
     * определяет, что нужно сказать для числа в игре FizzBuzz
     *
     * @number - число
     * @return возвращает Fizz, Buzz, FizzBuzz или само число
     */
    fun compute(number: Int) : String {
        return when {
            number % 3 == 0 && number % 5 == 0 -> "FizzBuzz"
            number % 3 == 0 -> "Fizz"
            number % 5 == 0 -> "Buzz"
            else -> number.toString()
        }
    }

}