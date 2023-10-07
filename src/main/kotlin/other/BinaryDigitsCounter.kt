package other

/**
 *
 * This algorithm counts the number of ones and zeros in a binary string
 * and implemented on a finite state machine
 *
 */

class BinaryDigitsCounter {

    /**
     * Stores the result of the algorithm
     */
    data class Result(private val ones: Int = 0, private val zeros: Int = 0)

    /**
     * Represents two states
     */
    private enum class State {
        ONE, ZERO
    }

    fun compute(binaryString: String): Result { // 1010010011
        if (binaryString.isEmpty()) {
            return Result()
        }

        // define initial state
        var currentState = if (binaryString.first() == '1') State.ONE else State.ZERO

        var onesCount = 0
        var zerosCount = 0

        binaryString.forEach { symbol ->
            // we use 'when' statement to toggle the state
            when (currentState) {
                State.ONE -> {
                    if (symbol == '0') {
                        zerosCount++
                        // move to another state
                        currentState = State.ZERO
                    } else {
                        onesCount++
                    }
                }
                State.ZERO -> {
                    if (symbol == '1') {
                        onesCount++
                        // move to another state
                        currentState = State.ONE
                    } else {
                        zerosCount++
                    }
                }
            }
        }

        return Result(onesCount, zerosCount)
    }

}