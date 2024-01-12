package design_patterns

/**
 *
 * Chain of responsibility is a behavioral design pattern that allows requests to be sent sequentially
 *
 * through a chain of handlers
 *
 */

enum class BlockFactor { ONE, TWO, THREE }

// I decided to give an analogy from the Minecraft game.
// In this game there are blocks that can be broken with a stone pickaxe, iron and diamond.
// For example: diamond may mine by iron and diamond pickaxes unlike cobblestone, which is mined by any pickaxe
abstract class Block(private val factor: BlockFactor) {
    fun mayMine(factor: BlockFactor) = this.factor.ordinal <= factor.ordinal
}

// the blocks are from the game
class StoneBlock: Block(BlockFactor.ONE)
class DiamondBlock: Block(BlockFactor.TWO)
class ObsidianBlock: Block(BlockFactor.THREE)

abstract class Pickaxe(private val factor: BlockFactor) {

    private var nextPickaxe: Pickaxe? = null

    fun changeNextPickaxe(pickaxe: Pickaxe) {
        nextPickaxe = pickaxe
    }

    // we mine the block, if it doesn't work, we take another pickaxe, if there is one, returns true if a pickaxe can mine
    fun mine(block: Block): Boolean {
        if (block.mayMine(factor)) return true

        return nextPickaxe?.mine(block) ?: false
    }

}

// the pickaxes are from the game
class StonePickaxe: Pickaxe(BlockFactor.ONE)

class IronPickaxe: Pickaxe(BlockFactor.TWO)

class DiamondPickaxe: Pickaxe(BlockFactor.THREE)