package other

/**
 * алгоритм Кнута Морриса Пратта для поиска подстроки в строке
 */
class KnuthMorrisPratt {

    /**
     * возвращает массив префикс функций для строки
     *
     * @str - строка
     */
    private fun prefixFunction(str: String) : Array<Int> {
        val pi = Array(str.length) { 0 }
        for (index in 1 until str.length) {
            var k = pi[index - 1]
            while (k > 0 && str[index] != str[k]) {
                k = pi[k - 1]
            }
            if (str[index] == str[k]) {
                k++
            }
            pi[index] = k
        }
        return pi
    }

    /**
     * возвращает true, если подстрока входит в строку
     *
     * @sub - подстрока
     * @str - строка
     */
    fun contains(sub: String, str: String) : Boolean {
        val summary = "$sub#$str"
        val pi = prefixFunction(summary)
        return pi.any { value -> value == sub.length }
    }

    /**
     * возвращает количество вхождений подстроки в строку
     *
     * @sub - подстрока
     * @str - строка
     */
    fun count(sub: String, str: String) : Int {
        val summary = "$sub#$str"
        return prefixFunction(summary).count { value -> value == sub.length }
    }
}