package en.other

/**
 * алгоритм переворота массива
 *
 * сложность алгоритма: n/2 операций
 */

class ReverseArray<T> {

    /**
     * создает и возвращает обратный массив для входного
     *
     * @array - входной массив
     * @return возвращает обратный массив
     */
    fun compute(array: Array<T>) : Array<T> {
        val newArray = array.copyOf()
        for (index in 0 until array.size / 2) {
            newArray[index] = newArray[array.size - index - 1].apply {
                newArray[array.size - index - 1] = newArray[index]
            }
        }
        return newArray
    }
}