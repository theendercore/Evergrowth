package org.teamvoided.evergrowth

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.evergrowth.config.EvergrowthConfig

object Evergrowth {
    const val MODID = "evergrowth"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(Evergrowth::class.simpleName)

    @JvmField
    var config = ConfigApi.registerAndLoadConfig(::EvergrowthConfig)

    fun init() {
        log.info("Hello from Common")
    }

    fun id(namespace: String, path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(namespace, path)
    fun mc(path: String): ResourceLocation = ResourceLocation.withDefaultNamespace(path)
    fun id(path: String) = id(MODID, path)
}
