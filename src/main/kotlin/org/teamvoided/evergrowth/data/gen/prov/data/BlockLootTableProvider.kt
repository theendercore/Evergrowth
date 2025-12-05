package org.teamvoided.evergrowth.data.gen.prov.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.core.HolderLookup
import net.minecraft.world.level.block.SlabBlock
import org.teamvoided.evergrowth.init.EverBlocks
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(o, r) {
    override fun generate() {

        for (block in EverBlocks.BLOCKS) {
            when (block) {
                is SlabBlock -> add(block, ::createSlabItemTable)
                else -> dropSelf(block)

            }
        }
    }

}