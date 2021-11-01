package design_patterns

import design_patterns.helpers.ViewContext

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