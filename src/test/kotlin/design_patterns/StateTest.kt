package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

class StateTest {

    @Test
    fun test() {
        val machine = CocaColaMachine()

        assertEquals("NoDollarCocaColaState", machine.currentState)
        machine.pressButton()
        assertEquals("NoDollarCocaColaState", machine.currentState)

        machine.insertDollar()
        assertEquals("HaveDollarCocaColaState", machine.currentState)
        machine.takeBackDollar()
        assertEquals("NoDollarCocaColaState", machine.currentState)
        machine.takeBackDollar()
        assertEquals("NoDollarCocaColaState", machine.currentState)

        machine.insertDollar()
        assertEquals("HaveDollarCocaColaState", machine.currentState)
        machine.pressButton()
        assertEquals("NoDollarCocaColaState", machine.currentState)

        machine.insertDollar()
        assertEquals("HaveDollarCocaColaState", machine.currentState)
        machine.pressButton()
        assertEquals("NoDollarCocaColaState", machine.currentState)

        machine.insertDollar()
        assertEquals("HaveDollarCocaColaState", machine.currentState)
        machine.pressButton()
        assertEquals("EmptyCocaColaState", machine.currentState)

        machine.insertDollar()
        assertEquals("EmptyCocaColaState", machine.currentState)

        machine.loadDrinks(1)
        machine.insertDollar()
        assertEquals("HaveDollarCocaColaState", machine.currentState)
        machine.pressButton()
        assertEquals("EmptyCocaColaState", machine.currentState)
    }

}