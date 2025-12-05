package org.teamvoided.evergrowth.init.helpers

import net.minecraft.core.Holder
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Items

object EverFoods {
    val STRAWBERRY: FoodProperties = food(2, 0.1f).fast().build()
    val STRAWBERRY_JAM: FoodProperties = food(4, 0.8f).usingConvertsTo(Items.GLASS_BOTTLE).build()
    val STRAWBERRY_TOAST: FoodProperties = food(7, 0.8f).build()
    val RED40: FoodProperties = FoodProperties.Builder()
        .effect(MobEffects.REGENERATION, 10)
        .effect(MobEffects.MOVEMENT_SPEED, 10)
        .effect(MobEffects.DAMAGE_RESISTANCE, 10)
        .effect(MobEffects.DAMAGE_BOOST, 10)
        .build()

    fun food(nutrition: Int, saturation: Float): FoodProperties.Builder =
        FoodProperties.Builder().nutrition(2).saturationModifier(saturation)

    fun FoodProperties.Builder.effect(
        effect: Holder<MobEffect>, length: Int, amplifier: Int = 0,
    ): FoodProperties.Builder = effect(MobEffectInstance(effect, length * 20, amplifier), 1f)

}