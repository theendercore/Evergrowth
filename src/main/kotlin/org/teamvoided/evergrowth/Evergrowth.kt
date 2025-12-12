package org.teamvoided.evergrowth

import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
//import me.fzzyhmstrs.fzzy_config.api.ConfigApi
//import org.teamvoided.evergrowth.config.EvergrowthConfig
import org.teamvoided.evergrowth.init.EverBlocks
import org.teamvoided.evergrowth.init.EverEntities
import org.teamvoided.evergrowth.init.EverItems
import org.teamvoided.evergrowth.init.EverTabs

object Evergrowth {
    const val MODID = "evergrowth"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(Evergrowth::class.simpleName)

//    @JvmField
//    var config = ConfigApi.registerAndLoadConfig(::EvergrowthConfig)

    fun init() {
        EverItems.init()
        EverBlocks.init()
        EverTabs.init()
        EverEntities.init()
    }

    fun id(namespace: String, path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(namespace, path)
    fun mc(path: String): ResourceLocation = ResourceLocation.withDefaultNamespace(path)
    fun id(path: String) = id(MODID, path)

    inline fun<reified T> Any?.cast(): T = this as T
}
