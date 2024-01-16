package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class MementoTest {

    @Test
    fun test() {
        // start Android system
        val androidOS = AndroidSystem()

        val greetingText = "Hello, World!"
        val greetingView = TextView()
        greetingView.setText(greetingText)
        greetingView.draw()

        // rotating Android device (recreating application components)
        // Android system saves the states of running applications
        androidOS.saveBundle(greetingView.onSaveInstanceState())

        // the state of the text was lost, but we saved it
        greetingView.setText("")

        // Android device has already rotated
        // The system restores the states of running applications
        greetingView.onRestoreInstanceState(androidOS.restoreBundle())

        assertEquals(greetingText, greetingView.text())
    }

}