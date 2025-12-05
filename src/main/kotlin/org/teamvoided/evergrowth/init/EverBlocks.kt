package org.teamvoided.evergrowth.init

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy
import org.teamvoided.evergrowth.Evergrowth.id
import org.teamvoided.evergrowth.init.helpers.EverBlockFamilies
import org.teamvoided.evergrowth.init.helpers.cutout
import org.teamvoided.evergrowth.init.helpers.stair
import org.teamvoided.evergrowth.init.helpers.translucent


@Suppress("unused", "MemberVisibilityCanBePrivate")
object EverBlocks {
    val BLOCKS = mutableListOf<Block>()
    val HOLY_PROP: BlockBehaviour.Properties = ofFullCopy(Blocks.DEEPSLATE)

    val BLOOD_MOSS = register("blood_moss", Block(ofFullCopy(Blocks.MOSS_BLOCK)))
    val BLOOD_MOSS_CARPET = register("blood_moss_carpet", CarpetBlock(ofFullCopy(Blocks.MOSS_CARPET)))

    val HOLYSTONE = register("holystone", Block(HOLY_PROP))
    val HOLYSTONE_STAIRS = register("holystone_stairs", stair(HOLYSTONE))
    val HOLYSTONE_SLAB = register("holystone_slab", SlabBlock(HOLY_PROP))
    val HOLYSTONE_WALL = register("holystone_wall", WallBlock(HOLY_PROP))

    val STRAWBERRY_PATCH = registerNoItem("strawberry_patch", Block(ofFullCopy(Blocks.PINK_PETALS))).cutout()
    val HOLY_LANTERN = register("holy_lantern", LanternBlock(ofFullCopy(Blocks.LANTERN))).cutout()
    val FOLLY_RED_GLASS =
        register("folly_red_glass", TransparentBlock(ofFullCopy(Blocks.PINK_STAINED_GLASS))).translucent()
    val FOLLY_RED_GLASS_PANE =
        register("folly_red_glass_pane", IronBarsBlock(ofFullCopy(Blocks.PINK_STAINED_GLASS_PANE))).translucent()

    fun init() = EverBlockFamilies.init()

    fun register(id: String, block: Block): Block {
        val regBlock = registerNoItem(id, block)
        EverItems.register(id, BlockItem(regBlock, Item.Properties()))
        return regBlock
    }

    fun registerNoItem(id: String, block: Block): Block {
        val regBlock = Registry.register(BuiltInRegistries.BLOCK, id(id), block)
        BLOCKS.add(regBlock)
        return regBlock
    }
}