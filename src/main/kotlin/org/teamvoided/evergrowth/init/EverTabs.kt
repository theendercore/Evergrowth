package org.teamvoided.evergrowth.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import org.teamvoided.evergrowth.Evergrowth.MODID
import org.teamvoided.evergrowth.Evergrowth.id


@Suppress("unused", "MemberVisibilityCanBePrivate")
object EverTabs {
    var TAB_NAME = "itemGroup.$MODID.$MODID"
    val TAB = register(
        MODID,
        FabricItemGroup.builder()
            .title(Component.translatable(TAB_NAME))
            .icon { EverItems.STRAWBERRY.defaultInstance }
            .displayItems { params, output ->
                output.acceptAll(EverItems.ITEMS.map(Item::getDefaultInstance))
            }

    )

    fun init() = Unit
    fun register(id: String, tab: CreativeModeTab.Builder): CreativeModeTab {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id(id), tab.build())
    }
}