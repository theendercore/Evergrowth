package org.teamvoided.evergrowth.data.gen.prov.data.tag

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import org.teamvoided.evergrowth.init.EverBlocks
import java.util.concurrent.CompletableFuture

class BlockTagsProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun addTags(lookup: HolderLookup.Provider) {
        getOrCreateTagBuilder(BlockTags.STAIRS).add(EverBlocks.HOLYSTONE_STAIRS)
        getOrCreateTagBuilder(BlockTags.SLABS).add(EverBlocks.HOLYSTONE_SLAB)
        getOrCreateTagBuilder(BlockTags.WALLS).add(EverBlocks.HOLYSTONE_WALL)

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
            EverBlocks.HOLYSTONE,
            EverBlocks.HOLYSTONE_STAIRS,
            EverBlocks.HOLYSTONE_SLAB,
            EverBlocks.HOLYSTONE_WALL,
            EverBlocks.HOLY_LANTERN,
        )
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE).add(
            EverBlocks.BLOOD_MOSS,
            EverBlocks.BLOOD_MOSS_CARPET,
            EverBlocks.STRAWBERRY_PATCH
        )

        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_BLOCKS).add(EverBlocks.FOLLY_RED_GLASS)
        getOrCreateTagBuilder(ConventionalBlockTags.GLASS_PANES).add(EverBlocks.FOLLY_RED_GLASS_PANE)
    }
}