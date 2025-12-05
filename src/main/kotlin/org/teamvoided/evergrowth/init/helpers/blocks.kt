package org.teamvoided.evergrowth.init.helpers

import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.StairBlock
import net.minecraft.world.level.block.state.BlockBehaviour

fun stair(block: Block): Block = StairBlock(block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block))


val CUTOUT_BLOCKS = mutableSetOf<Block>()
val TRANSLUCENT_BLOCKS = mutableSetOf<Block>()

fun Block.cutout(): Block {
    CUTOUT_BLOCKS.add(this)
    return this
}

fun Block.translucent(): Block {
    TRANSLUCENT_BLOCKS.add(this)
    return this
}