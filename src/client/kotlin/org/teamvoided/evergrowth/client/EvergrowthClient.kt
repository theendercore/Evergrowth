package org.teamvoided.evergrowth.client

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.entity.SheepRenderer
import org.teamvoided.evergrowth.Evergrowth
import org.teamvoided.evergrowth.init.EverEntities
import org.teamvoided.evergrowth.init.helpers.CUTOUT_BLOCKS
import org.teamvoided.evergrowth.init.helpers.TRANSLUCENT_BLOCKS
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap.INSTANCE as BlockMap

@Suppress("unused")
object EvergrowthClient {
    fun init() {
        Evergrowth.log.info("Hello from Client")
        EntityRendererRegistry.register(EverEntities.HOLIELAMB, ::SheepRenderer)

        CUTOUT_BLOCKS.forEach { BlockMap.putBlock(it, RenderType.cutout()) }
        TRANSLUCENT_BLOCKS.forEach { BlockMap.putBlock(it, RenderType.translucent()) }
    }
}