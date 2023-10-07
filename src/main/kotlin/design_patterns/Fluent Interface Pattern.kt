package design_patterns

/**
 *
 * pattern: Fluent Interface
 *
 * using: used to implement chaining methods
 *
 * description: the object has special methods that change it and return it
 * with a new state for further manipulations
 *
 */

class View {
    private var isFocusable = false
    private var isClickable = false
    private var bgColor: Int = 0x444444

    fun hasFocus() = isFocusable
    fun isClickable() = isClickable
    fun bgColor() = bgColor

    fun focusable() = apply {
        isFocusable = true
    }

    fun clickable() = apply {
        isClickable = true
    }

    fun bg(color: Int) = apply {
        bgColor = color
    }

    fun draw() {}

}