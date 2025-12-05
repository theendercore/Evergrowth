package org.teamvoided.evergrowth.init

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.ItemNameBlockItem
import org.teamvoided.evergrowth.Evergrowth.id
import org.teamvoided.evergrowth.init.helpers.EverFoods


@Suppress("unused", "MemberVisibilityCanBePrivate")
object EverItems {
    val ITEMS = mutableListOf<Item>()

    val ATHAME = register("athame", Item(Properties()))
    val STRAWBERRY =
        register("strawberry", ItemNameBlockItem(EverBlocks.STRAWBERRY_PATCH, Properties().food(EverFoods.STRAWBERRY)))
    val STRAWBERRY_JAM = register("strawberry_jam", Item(Properties().food(EverFoods.STRAWBERRY_JAM)))
    val STRAWBERRY_TOAST = register("strawberry_toast", Item(Properties().food(EverFoods.STRAWBERRY_TOAST)))
    val RED40 = register("red40", Item(Properties().food(EverFoods.RED40)))
    val HOLY_BLOOD = register("holy_blood", Item(Properties()))
    val HEART_OF_THE_HARVEST = register("heart_of_the_harvest", Item(Properties()))
    val ALTALUNE = register("altalune", Item(Properties()))
    val SOLANUM = register("solanum", Item(Properties()))

    fun init() = Unit
    fun register(id: String, item: Item): Item {
        val regItem = Registry.register(BuiltInRegistries.ITEM, id(id), item)
        ITEMS.add(regItem)
        return regItem
    }
}