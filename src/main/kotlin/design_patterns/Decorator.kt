package design_patterns

/**
 *
 * pattern: Decorator
 *
 * using: used to add additional functionality to an object
 *
 * description: classes implement a common interface and to extend the functionality of the previous object,
 * the old object is passed through the constructor
 *
 */

interface MyPrinter {
    fun printedText() : String
}

/**
 * just returns "Hello"
 */
class HelloPrinter : MyPrinter {
    override fun printedText() : String {
        return "Hello"
    }
}

/**
 * adds a comma to the previous value of the printedText() function
 */
class CommaPrinter(private val printer: MyPrinter) : MyPrinter {
    override fun printedText() : String {
        return "${printer.printedText()},"
    }
}

/**
 * adds a space to the previous value of the printedText() function
 */
class SpacePrinter(private val printer: MyPrinter) : MyPrinter {
    override fun printedText() : String {
        return "${printer.printedText()} "
    }
}

/**
 * adds the word "World" to the previous value of the printedText() function
 */
class WorldPrinter(private val printer: MyPrinter) : MyPrinter {
    override fun printedText() : String {
        return "${printer.printedText()}World"
    }
}

/**
 * adds an exclamation mark to the previous value of the printedText() function
 */
class ExclamationPrinter(private val printer: MyPrinter) : MyPrinter {
    override fun printedText() : String {
        return "${printer.printedText()}!"
    }
}