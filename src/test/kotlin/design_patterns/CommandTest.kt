package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class CommandTest {

    @Test
    fun `test usual commands`() {
        val stereoSystem = StereoSystem()
        val remoteControl = StereoSystemRemoteControl(mapOf(
            "turnOn" to TurnOnCommand(stereoSystem),
            "turnOff" to TurnOffCommand(stereoSystem),
            "volume+" to IncreaseVolumeCommand(stereoSystem),
            "volume-" to DecreaseVolumeCommand(stereoSystem)
        ))

        remoteControl.pressButton("turnOn")

        assertEquals("""
            running status: true
            volume value: 50
        """.trimIndent(), stereoSystem.currentState)

        remoteControl.pressButton("volume+")
        remoteControl.pressButton("volume+")
        remoteControl.pressButton("volume+")

        assertEquals("""
            running status: true
            volume value: 80
        """.trimIndent(), stereoSystem.currentState)

        remoteControl.pressUndoButton()
        remoteControl.pressUndoButton()
        remoteControl.pressUndoButton()
        remoteControl.pressUndoButton()

        assertEquals("""
            running status: false
            volume value: 50
        """.trimIndent(), stereoSystem.currentState)
    }

    @Test
    fun `test macro command`() {
        val stereoSystem = StereoSystem()
        val remoteControl = StereoSystemRemoteControl(mapOf(
            "party" to MacroCommand(
                TurnOnCommand(stereoSystem),
                IncreaseVolumeCommand(stereoSystem),
                IncreaseVolumeCommand(stereoSystem),
                IncreaseVolumeCommand(stereoSystem),
                IncreaseVolumeCommand(stereoSystem),
                IncreaseVolumeCommand(stereoSystem)
            )
        ))

        remoteControl.pressButton("party")

        assertEquals("""
            running status: true
            volume value: 100
        """.trimIndent(), stereoSystem.currentState)

        remoteControl.pressUndoButton()

        assertEquals("""
            running status: false
            volume value: 50
        """.trimIndent(), stereoSystem.currentState)
    }

}