package design_patterns

/**
 *
 * pattern: Memento
 *
 * allows without violating encapsulation, to fix and save the state of an object
 * in such a way as to restore it to this state
 *
 */


class Bundle(val str: String)

/**
 * Android system emulating
 */
class AndroidSystem {
    private var bundle: Bundle = Bundle("")

    fun saveBundle(bundle: Bundle) {
        this.bundle = bundle
    }

    fun restoreBundle() = bundle
}

/**
 * TextView is an Android component that draws text on the screen
 */
class TextView1 {
    private var text: String = ""

    fun setText(text: String) {
        this.text = text
    }

    fun text() = text

    fun draw() {
        println(text)
    }

    fun onSaveInstanceState(): Bundle {
        return Bundle(text)
    }

    fun onRestoreInstanceState(bundle: Bundle) {
        text = bundle.str
    }
}