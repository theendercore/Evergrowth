package org.teamvoided.evergrowth.data

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.entity.EntityType
import org.teamvoided.evergrowth.Evergrowth.id

object EverEntityTypeTags {
    var HOLIELAMB_SACRIFICE = key("holielamb_sacrifice")

    fun key(name: String): TagKey<EntityType<*>> = TagKey.create(Registries.ENTITY_TYPE, id(name))
}