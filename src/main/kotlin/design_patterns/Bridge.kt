package design_patterns

/**
 *
 * Bridge is a structural design pattern used to separate abstraction and implementation
 *
 * so they can change independently
 *
 */

// OperatingSystem implements an internal algorithm for drawing primitives (operating systems are implementations in this example)
abstract class OperatingSystem(private val name: String, private val version: Int) {

    protected val lines = mutableListOf<String>()
    protected val circles = mutableListOf<String>()

    abstract fun drawLine(startX: Int, startY: Int, endX: Int, endY: Int)

    abstract fun drawCircle(centerX: Int, centerY: Int, radius: Int)

    override fun toString(): String {
        return """
            $name $version
            Lines:
            ${lines.joinToString("\n")}
            Circles:
            ${circles.joinToString("\n")}
        """.trimIndent()
    }

}

// different implementations have different algorithms for drawing primitives
class WindowsSystem : OperatingSystem("Windows", 10) {

    override fun drawLine(startX: Int, startY: Int, endX: Int, endY: Int) {
        lines.add("Windows graphic subsystem -> startX: $startX, startY: $startY, endX: $endX, endY: $endY")
    }

    override fun drawCircle(centerX: Int, centerY: Int, radius: Int) {
        circles.add("Windows graphic subsystem -> centerX: $centerX, centerY: $centerY, radius: $radius")
    }

}

class MacOSSystem : OperatingSystem("MacOS", 14) {

    override fun drawLine(startX: Int, startY: Int, endX: Int, endY: Int) {
        lines.add("MacOS graphic subsystem -> startX: $startX, startY: $startY, endX: $endX, endY: $endY")
    }

    override fun drawCircle(centerX: Int, centerY: Int, radius: Int) {
        circles.add("MacOS graphic subsystem -> centerX: $centerX, centerY: $centerY, radius: $radius")
    }

}

// we can add new primitives without changing OperatingSystem implementations (primitives are abstractions in this example)
abstract class GraphicPrimitive {
    abstract fun draw(system: OperatingSystem)
}

class GraphicCirclePrimitive(
    private val centerX: Int,
    private val centerY: Int,
    private val radius: Int
) : GraphicPrimitive() {

    override fun draw(system: OperatingSystem) {
        system.drawCircle(centerX, centerY, radius)
    }

}

class GraphicLinePrimitive(
    private val startX: Int,
    private val startY: Int,
    private val endX: Int,
    private val endY: Int
) : GraphicPrimitive() {

    override fun draw(system: OperatingSystem) {
        system.drawLine(startX, startY, endX, endY)
    }

}