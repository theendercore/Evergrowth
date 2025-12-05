package org.teamvoided.evergrowth.data.gen.prov.assets

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import org.teamvoided.evergrowth.init.EverBlocks
import org.teamvoided.evergrowth.init.EverEntities
import org.teamvoided.evergrowth.init.EverItems
import org.teamvoided.evergrowth.init.EverTabs
import java.util.concurrent.CompletableFuture

class EnLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) : FabricLanguageProvider(o, r) {

    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        EverItems.ITEMS.forEach { gen.add(it.descriptionId, genLang(it.id)) }
        EverBlocks.BLOCKS.forEach { silentTry { gen.add(it.descriptionId, genLang(it.id)) } }
        EverEntities.HOLIELAMB.let { gen.add(it.descriptionId, genLang(it.id)) }
//        EverItemTags.ITEM_TAGS.forEach { gen.add(it.descriptionId, genLang(it.id)) }

        gen.add(EverTabs.TAB_NAME, "Evergrowth")
    }

    private fun genLang(id: ResourceLocation): String =
        id.path.split("_").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }

    val Item.id get() = BuiltInRegistries.ITEM.getKey(this)
    val Block.id get() = BuiltInRegistries.BLOCK.getKey(this)
    val EntityType<*>.id get() = BuiltInRegistries.ENTITY_TYPE.getKey(this)

    fun silentTry(fn: Runnable) {
        try {
            fn.run()
        } catch (_: Exception) {
        }
    }
}