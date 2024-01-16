package design_patterns

/**
 *
 * Memento is a behavioral design pattern that allows without violating encapsulation to capture
 *
 * and save the internal state of an object so that it can be restored to this state later
 *
 */


class Bundle(val str: String)

// Android system saves the application state in special bundles
// I gave this as an example, Android system’s saving mechanism is much more complicated
class AndroidSystem {

    private var savedBundle: Bundle = Bundle("")

    fun saveBundle(bundle: Bundle) {
        savedBundle = bundle
    }

    fun restoreBundle() = savedBundle
}

// TextView is an Android component that draws text on the screen
class TextView {

    private var currentText: String = ""

    fun setText(text: String) {
        currentText = text
    }

    fun text() = currentText

    fun draw() {
        println(currentText)
    }

    // saves the current state of TextView before re-creating it
    fun onSaveInstanceState(): Bundle {
        return Bundle(currentText)
    }

    // restores the current state after TextView is recreated
    fun onRestoreInstanceState(bundle: Bundle) {
        currentText = bundle.str
    }
}