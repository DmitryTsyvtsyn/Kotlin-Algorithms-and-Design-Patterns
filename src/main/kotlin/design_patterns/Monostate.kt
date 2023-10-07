package design_patterns

/**
 *
 * pattern: MonoState
 *
 * using: used where you need to have common data for different objects of the same class
 *
 * description: the Monostate pattern is very similar to the Singleton pattern. The difference is
 * that in the Singleton pattern we have only one object, while in Monostate the objects use the same data.
 *
 */

class TextView {
    companion object {
        /**
         * stores the number of TextView elements created
         */
        private var count = 0
    }

    /**
     * returns the number of TextView elements created
     */
    fun textViewCount() = count

    init {
        count++
    }

    fun onDetachView() {
        count--
    }
}