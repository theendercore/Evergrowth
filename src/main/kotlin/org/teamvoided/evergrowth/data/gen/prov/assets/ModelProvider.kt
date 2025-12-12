package org.teamvoided.evergrowth.data.gen.prov.assets

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelTemplates
import org.teamvoided.evergrowth.init.EverBlocks
import org.teamvoided.evergrowth.init.EverItems
import org.teamvoided.evergrowth.init.helpers.EverBlockFamilies

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
    override fun generateBlockStateModels(gen: BlockModelGenerators) {
        gen.createFullAndCarpetBlocks(EverBlocks.BLOOD_MOSS, EverBlocks.BLOOD_MOSS_CARPET)
        gen.family(EverBlockFamilies.HOLYSTONE_TILES.baseBlock).generateFor(EverBlockFamilies.HOLYSTONE_TILES)

        gen.createTrivialCube(EverBlocks.STRAWBERRY_PATCH)
        gen.createLantern(EverBlocks.HOLY_LANTERN)
        gen.createGlassBlocks(EverBlocks.FOLLY_RED_GLASS, EverBlocks.FOLLY_RED_GLASS_PANE)
    }

    override fun generateItemModels(gen: ItemModelGenerators) {
        val faltItems = listOf(
            EverItems.ATHAME,
            EverItems.STRAWBERRY,
            EverItems.STRAWBERRY_JAM,
            EverItems.STRAWBERRY_TOAST,
            EverItems.RED40,
            EverItems.HOLY_BLOOD,
            EverItems.HEART_OF_THE_HARVEST,
            EverItems.ALTALUNE,
            EverItems.SOLANUM,
            EverItems.MEOW_DISC,
        )
        for (item in faltItems) {
            gen.generateFlatItem(item, ModelTemplates.FLAT_ITEM)
        }
    }

}