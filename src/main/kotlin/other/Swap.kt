package other

/**
 * алгоритма обмена двух переменных без третьей дополнительной
 *
 */

class Swap {

    /**
     * Kotlin расширение для проверки индекса списка на корректность
     *
     * @return возвращает true, если элемент доступен по индексу
     */
    private fun  List<Int>.inIndex(index: Int) = index in 0 until size

    /**
     * Kotlin расширение для проверки индекса массива на корректность
     *
     * @return возвращает true, если элемент доступен по индексу
     */
    private fun Array<Int>.inIndex(index: Int) = index in 0 until size

    /**
     * меняет местами два значения списка по указанным индексам
     *
     * @list - список
     * @old - индекс первого элемента
     * @new - индекс второго элемента
     */
    fun swap(list: MutableList<Int>, old: Int, new: Int) {
        if (list.inIndex(old) && list.inIndex(new)) {
            list[old] = list[old] + list[new]
            list[new] = list[old] - list[new]
            list[old] = list[old] - list[new]
        }
    }

    /**
     * меняет местами два значения массива по указанным индексам
     *
     * @list - массив
     * @old - индекс первого элемента
     * @new - индекс второго элемента
     */
    fun swap(array: Array<Int>, old: Int, new: Int) {
        if (array.inIndex(old) && array.inIndex(new)) {
            array[old] = array[old] + array[new]
            array[new] = array[old] - array[new]
            array[old] = array[old] - array[new]
        }
    }
}