package org.teamvoided.evergrowth.init.helpers

import net.minecraft.data.BlockFamilies
import net.minecraft.data.BlockFamily
import org.teamvoided.evergrowth.init.EverBlocks

object EverBlockFamilies {
    val HOLYSTONE_TILES: BlockFamily = BlockFamilies.familyBuilder(EverBlocks.HOLYSTONE)
        .slab(EverBlocks.HOLYSTONE_SLAB)
        .stairs(EverBlocks.HOLYSTONE_STAIRS)
        .wall(EverBlocks.HOLYSTONE_WALL)
        .family

    fun init() = Unit
}