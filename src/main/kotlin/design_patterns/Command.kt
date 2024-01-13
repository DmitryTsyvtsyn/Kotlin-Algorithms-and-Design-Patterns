package design_patterns

/**
 *
 * Command is a behavioral pattern that encapsulates a request to perform an action as a separate object
 *
 */

// StereoSystem is the receiver that performs the action
class StereoSystem {

    private var hasTurnedOn = false
    private var volume = 50

    val currentState: String
        get() = """
            running status: $hasTurnedOn
            volume value: $volume
        """.trimIndent()

    fun turnOn() {
        hasTurnedOn = true
    }

    fun turnOff() {
        hasTurnedOn = false
    }

    fun increaseVolume() {
        if (!hasTurnedOn) return
        if (volume < 100) {
            volume += 10
        }
    }

    fun decreaseVolume() {
        if (!hasTurnedOn) return
        if (volume > 0) {
            volume -= 10
        }
    }

}

interface StereoSystemCommand {
    fun execute()
    fun undo() : Boolean
}

// this command encapsulates a request to increase the volume in StereoSystem
class IncreaseVolumeCommand(private val stereoSystem: StereoSystem) : StereoSystemCommand {

    override fun execute() {
        stereoSystem.increaseVolume()
    }

    override fun undo(): Boolean {
        stereoSystem.decreaseVolume()
        return true
    }

}

// this command encapsulates a request to decrease the volume in StereoSystem
class DecreaseVolumeCommand(private val stereoSystem: StereoSystem) : StereoSystemCommand {

    override fun execute() {
        stereoSystem.decreaseVolume()
    }

    override fun undo(): Boolean {
        stereoSystem.increaseVolume()
        return true
    }

}

// this command encapsulates a request to turn on StereoSystem
class TurnOnCommand(private val stereoSystem: StereoSystem) : StereoSystemCommand {

    override fun execute() {
        stereoSystem.turnOn()
    }

    override fun undo(): Boolean {
        stereoSystem.turnOff()
        return true
    }

}

// this command encapsulates a request to turn off StereoSystem
class TurnOffCommand(private val stereoSystem: StereoSystem) : StereoSystemCommand {

    override fun execute() {
        stereoSystem.turnOff()
    }

    override fun undo() = false

}

// we can also create the command that combines others
class MacroCommand(private vararg val commands: StereoSystemCommand) : StereoSystemCommand {

    override fun execute() {
        for (command in commands) {
            command.execute()
        }
    }

    override fun undo(): Boolean {
        for (command in commands.reversed()) {
            val isNotCancelableCommand = !command.undo()
            if (isNotCancelableCommand) return false
        }
        return true
    }

}

// StereoSystemRemoteControl executes commands without breaking their encapsulation
class StereoSystemRemoteControl(private val buttons: Map<String, StereoSystemCommand> = mapOf()) {

    // we only know about StereoSystemCommand interface
    private val commandHistory = mutableListOf<StereoSystemCommand>()

    fun pressButton(name: String) {
        val command = buttons[name]
        if (command != null) {
            command.execute()
            commandHistory.add(command)
        }
    }

    fun pressUndoButton() {
        val lastCommand = commandHistory.removeLastOrNull()
        if (lastCommand != null) {
            val isNotCancelableCommand = !lastCommand.undo()
            if (isNotCancelableCommand) commandHistory.clear()
        }
    }

}