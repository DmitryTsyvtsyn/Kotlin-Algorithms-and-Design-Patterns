package design_patterns

import design_patterns.helpers.ViewContext

/**
 * название: паттерн Fluent Interface
 *
 * применение: используется для реализации методов цепочек
 *
 * описание: объект имеет специальные методы, которые изменяют его и
 * возвращают с новым состоянием для дальнейших манипуляций
 */

class View(ctx: ViewContext) {
    private var isFocusable = false
    private var isClickable = false
    private var bgColor: Int = 0x444444

    fun focusable() = isFocusable
    fun clickable() = isClickable
    fun bgColor() = bgColor

    fun makeFocusable() = apply {
        isFocusable = true
    }

    fun makeClickable() = apply {
        isClickable = true
    }

    fun changeBackground(color: Int) = apply {
        bgColor = color
    }

    fun draw() {}

}