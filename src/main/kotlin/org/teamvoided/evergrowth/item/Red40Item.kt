package org.teamvoided.evergrowth.item

import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.animal.Sheep
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import org.teamvoided.evergrowth.init.EverEntities

class Red40Item(properties: Properties) : Item(properties) {
    override fun interactLivingEntity(
        stack: ItemStack, player: Player, sheep: LivingEntity, interactionHand: InteractionHand,
    ): InteractionResult {
        if (sheep is Sheep && sheep.isAlive) {
            sheep.level().playSound(player, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0f, 1.0f)
            if (!player.level().isClientSide) {
                sheep.convertTo(EverEntities.HOLIELAMB, true)
                stack.shrink(1)
            }

            return InteractionResult.sidedSuccess(player.level().isClientSide)
        } else {
            return InteractionResult.PASS
        }
    }
}