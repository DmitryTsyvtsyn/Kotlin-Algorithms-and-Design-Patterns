package other

class SieveOfEratosthenes {

    fun compute(maxNumber: Int) : List<Int> {
        val numbers = Array(maxNumber + 1) { index -> index >= 2 }

        var x = 2
        while (x * x <= maxNumber) {
            if (numbers[x]) {
                for (y in x*x..maxNumber step x) {
                    numbers[y] = false
                }
            }
            x++
        }

        val primes = mutableListOf<Int>()

        numbers.forEachIndexed { number, isPrime ->
            if (isPrime) {
                primes.add(number)
            }
        }

        return primes
    }

}