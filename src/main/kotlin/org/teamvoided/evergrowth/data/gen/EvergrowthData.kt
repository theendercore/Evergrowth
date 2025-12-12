package org.teamvoided.evergrowth.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.RegistrySetBuilder
import org.teamvoided.evergrowth.Evergrowth.log
import org.teamvoided.evergrowth.data.gen.prov.assets.EnLangProvider
import org.teamvoided.evergrowth.data.gen.prov.assets.ModelProvider
import org.teamvoided.evergrowth.data.gen.prov.data.BlockLootTableProvider
import org.teamvoided.evergrowth.data.gen.prov.data.RecipeProvider
import org.teamvoided.evergrowth.data.gen.prov.data.tag.BlockTagsProvider
import org.teamvoided.evergrowth.data.gen.prov.data.tag.EntityTypeTagsProvider
import org.teamvoided.evergrowth.data.gen.prov.data.tag.ItemTagsProvider

@Suppress("unused")
object EvergrowthData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        // Assets
        pack.addProvider(::ModelProvider)
        pack.addProvider(::EnLangProvider)
        // Data
        pack.addProvider(::BlockLootTableProvider)
        val bt = pack.addProvider(::BlockTagsProvider)
        pack.addProvider { o, r -> ItemTagsProvider(o, r, bt) }
        pack.addProvider(::EntityTypeTagsProvider)
        pack.addProvider(::RecipeProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }
}
