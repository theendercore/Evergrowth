package org.teamvoided.evergrowth.data.gen.prov.data.tag

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.world.entity.EntityType
import org.teamvoided.evergrowth.data.EverEntityTypeTags
import java.util.concurrent.CompletableFuture

class EntityTypeTagsProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.EntityTypeTagProvider(output, registriesFuture) {
    override fun addTags(lookup: HolderLookup.Provider) {
        getOrCreateTagBuilder(EverEntityTypeTags.HOLIELAMB_SACRIFICE).add(EntityType.SHEEP)
    }
}