package design_patterns

import design_patterns.helpers.ViewContext

/**
 * паттерн Monostate является синтаксическим сахаром для Singleton паттерна,
 * В Singleton паттерне мы можем иметь только один объект, а в Monostate объекты
 * используют одни и те же данные
 *
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