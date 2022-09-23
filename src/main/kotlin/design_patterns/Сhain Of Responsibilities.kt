package design_patterns

/**
 *
 * pattern: Chain of responsibility
 *
 * description: a design pattern consisting of “a source of command objects and a series of processing objects”.
 * Each processing object in the chain is responsible for a certain type of command, and the processing is done,
 * it forwards the command to the next processor in the chain.
 *
 */

enum class BlockFactor {
    ONE, TWO, THREE
}

/**
 *
 * I decided to give an analogy from the Minecraft game.
 * In this game there are blocks that can be broken with a stone pickaxe, iron and diamond.
 * For example: diamond may mine by iron and diamond pickaxes unlike cobblestone, which is mined by any
 *
 */
abstract class Block(private val factor: BlockFactor) {
    fun mayMine(factor: BlockFactor) = this.factor.ordinal <= factor.ordinal
}

/**
 *
 * blocks from the game
 *
 */
class StoneBlock: Block(BlockFactor.ONE)
class DiamondBlock: Block(BlockFactor.TWO)
class ObsidianBlock: Block(BlockFactor.THREE)

abstract class Pickaxe(private val factor: BlockFactor) {

    private var nextPickaxe: Pickaxe? = null
    fun changeNextPickaxe(pickaxe: Pickaxe) {
        this.nextPickaxe = pickaxe
    }

    /**
     *
     * we mine the block, if it doesn't work, we take another pickaxe, if there is one
     *
     * @return return true if a pickaxe can mine
     */
    fun mine(block: Block): Boolean =
        if (block.mayMine(factor)) {
            true
        } else {
            nextPickaxe?.mine(block) ?: false
        }

}

/**
 *
 * pickaxes from the game
 *
 */
class StonePickaxe: Pickaxe(BlockFactor.ONE)

class IronPickaxe: Pickaxe(BlockFactor.TWO)

class DiamondPickaxe: Pickaxe(BlockFactor.THREE)