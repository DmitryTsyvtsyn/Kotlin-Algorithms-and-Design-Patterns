package design_patterns

/**
 *
 * State is a behavioral design pattern that controls changes in the behavior of an object
 *
 * when its internal state changes
 *
 */

// the common interface for all states
interface CocaColaState {
    fun insertDollar() : Boolean
    fun takeBackDollar() : Boolean
    fun pressButton(numberOfDrinks: Int) : Boolean
}

// we don't have drinks in the machine
class EmptyCocaColaState : CocaColaState {
    override fun insertDollar() = false
    override fun takeBackDollar() = false
    override fun pressButton(numberOfDrinks: Int) = false
    override fun toString(): String = "EmptyCocaColaState"
}

// we have drinks, but we don't have a dollar in the machine
class NoDollarCocaColaState(private val machine: CocaColaMachine) : CocaColaState {
    override fun insertDollar(): Boolean {
        machine.setState(HaveDollarCocaColaState(machine))
        return true
    }

    override fun takeBackDollar() = false
    override fun pressButton(numberOfDrinks: Int) = false
    override fun toString(): String = "NoDollarCocaColaState"
}

// we have a dollar in the machine
class HaveDollarCocaColaState(private val machine: CocaColaMachine) : CocaColaState {
    override fun insertDollar() = false
    override fun takeBackDollar(): Boolean {
        machine.setState(NoDollarCocaColaState(machine))
        return true
    }
    override fun pressButton(numberOfDrinks: Int): Boolean {
        if (numberOfDrinks == 1) {
            machine.setState(EmptyCocaColaState())
        } else {
            machine.setState(NoDollarCocaColaState(machine))
        }
        return true
    }
    override fun toString(): String = "HaveDollarCocaColaState"
}

// CocaColaMachine switches between states
class CocaColaMachine {

    private var numberOfDrinks = 3
    private var state: CocaColaState = NoDollarCocaColaState(this)

    val currentState: String
        get() = state.toString()

    fun insertDollar() = state.insertDollar()

    fun takeBackDollar() = state.takeBackDollar()

    fun pressButton(): Boolean {
        val isSuccess = state.pressButton(numberOfDrinks)
        if (isSuccess) {
            numberOfDrinks -= 1
        }
        return isSuccess
    }

    fun loadDrinks(count: Int) {
        numberOfDrinks += count
        if (numberOfDrinks > 0) {
            setState(NoDollarCocaColaState(this))
        } else {
            setState(EmptyCocaColaState())
        }
    }

    fun setState(newState: CocaColaState) {
        state = newState
    }

}