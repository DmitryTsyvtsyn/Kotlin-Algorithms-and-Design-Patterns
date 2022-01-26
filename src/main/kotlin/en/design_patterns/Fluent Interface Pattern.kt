package en.design_patterns

import en.design_patterns.helpers.ViewContext

/**
 * name: Fluent Interface
 *
 * using: used to implement chaining methods
 *
 * description: the object has special methods that change it and return it
 * with a new state for further manipulations
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