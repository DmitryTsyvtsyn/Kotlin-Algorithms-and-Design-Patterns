package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions

class MementoTest {

    @Test
    fun test() {
        // start Android system
        val androidOS = AndroidSystem()

        val greetingText = TextView1()
        greetingText.setText(greeting)
        greetingText.draw()

        // rotating Android device (recreating application components)
        // saving state
        androidOS.saveBundle(greetingText.onSaveInstanceState())

        // the state of the text was lost, but we saved it
        greetingText.setText("")

        // Android device has already rotated
        // restoring state
        greetingText.onRestoreInstanceState(androidOS.restoreBundle())

        Assertions.assertEquals(greeting, greetingText.text())
    }

    companion object {
        private const val greeting = "Hello, World!"
    }
}