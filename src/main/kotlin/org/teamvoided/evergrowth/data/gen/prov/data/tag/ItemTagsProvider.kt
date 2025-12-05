package org.teamvoided.evergrowth.data.gen.prov.data.tag

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import org.teamvoided.evergrowth.init.EverItems
import java.util.concurrent.CompletableFuture

class ItemTagsProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>, bt: BlockTagsProvider) :
    FabricTagProvider.ItemTagProvider(o, r, bt) {
    override fun addTags(lookup: HolderLookup.Provider) {
        getOrCreateTagBuilder(ItemTags.HOES).add(EverItems.ALTALUNE)
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(EverItems.SOLANUM)


        copy(BlockTags.STAIRS, ItemTags.STAIRS)
        copy(BlockTags.SLABS, ItemTags.SLABS)
        copy(BlockTags.WALLS, ItemTags.WALLS)
        copy(ConventionalBlockTags.GLASS_BLOCKS, ConventionalItemTags.GLASS_BLOCKS)
        copy(ConventionalBlockTags.GLASS_PANES, ConventionalItemTags.GLASS_PANES)
    }
}