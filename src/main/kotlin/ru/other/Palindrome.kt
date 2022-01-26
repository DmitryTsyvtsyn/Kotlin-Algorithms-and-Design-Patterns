package ru.other

/**
 * Алгоритм проверки строки на палиндром
 *
*/

class Palindrome(private val text: String) {

    /**
     * проверяет строку на палиндром
     *
     * @return возвращает true, если строка является палиндромом
     */
    fun isYes() = text == text.reversed()

    /**
     * проверяет строку на то, что она не является палиндромом
     *
     * @return возвращает true, если строка не является палиндромом
     */
    fun isNot() = text != text.reversed()

}