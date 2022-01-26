package ru.design_patterns

import ru.design_patterns.helpers.ViewContext

/**
 * название: паттерн MonoState
 *
 * применение: используется там, где нужно иметь общие данные для разных объектов одного и того же класса
 *
 * описание: паттерн Monostate очень похож на Singleton паттерн. Разница состоит в том, что в Singleton паттерне мы имеем только один объект,
 * а в Monostate объекты используют одни и те же данные
 */

class TextView(ctx: ViewContext) {
    companion object {
        /**
         * хранит количество созданных TextView элементов
         *
         */
        private var count = 0
    }

    /**
     * возвращает количество созданных TextView элементов
     *
     */
    fun textViewCount() = count

    init {
        count++
    }

    fun onDetachView() {
        count--
    }
}