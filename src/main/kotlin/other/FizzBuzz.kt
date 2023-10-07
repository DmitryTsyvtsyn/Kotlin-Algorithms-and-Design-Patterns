package other

/**
 * The simplest FizzBuzz game
 *
 * description: the player says numbers in sequence, provided:
 *  - if the number is divisible by 3 it says fizz
 *  - if the number is divisible by 5 it says buzz
 *  - if the number is divisible by both 3 and 5, it says FizzBuzz
 *  - otherwise, the player calls the number itself
 */

class FizzBuzz {

    /**
     * determines what to say for a number in the FizzBuzz game and returns Fizz, Buzz, FizzBuzz or number
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