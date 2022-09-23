package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions

class ChainOfResponsibilitiesTest {

    @Test
    fun test_when_we_have_only_stone_pickaxe() {
        val pickaxe = StonePickaxe()

        Assertions.assertEquals(true, pickaxe.mine(StoneBlock()))
        Assertions.assertEquals(false, pickaxe.mine(DiamondBlock()))
        Assertions.assertEquals(false, pickaxe.mine(ObsidianBlock()))
    }

    @Test
    fun test_when_we_have_stone_and_iron_pickaxes() {
        val pickaxe = StonePickaxe()
        pickaxe.changeNextPickaxe(IronPickaxe())

        Assertions.assertEquals(true, pickaxe.mine(StoneBlock()))
        Assertions.assertEquals(true, pickaxe.mine(DiamondBlock()))
        Assertions.assertEquals(false, pickaxe.mine(ObsidianBlock()))
    }

    @Test
    fun test_when_we_have_all_three_pickaxes() {
        val pickaxe = StonePickaxe()
        val ironPickaxe = IronPickaxe().apply {
            changeNextPickaxe(DiamondPickaxe())
        }
        pickaxe.changeNextPickaxe(ironPickaxe)

        Assertions.assertEquals(true, pickaxe.mine(StoneBlock()))
        Assertions.assertEquals(true, pickaxe.mine(DiamondBlock()))
        Assertions.assertEquals(true, pickaxe.mine(ObsidianBlock()))
    }


}