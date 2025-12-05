package org.teamvoided.evergrowth.config

import me.fzzyhmstrs.fzzy_config.annotations.NonSync
import me.fzzyhmstrs.fzzy_config.config.Config
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedNumber.WidgetType.TEXTBOX_WITH_BUTTONS
import org.teamvoided.evergrowth.Evergrowth.MODID
import org.teamvoided.evergrowth.Evergrowth.id

@Suppress("unused")
class EvergrowthConfig : Config(id(MODID)) {
    var groupName = ConfigGroup("group_id", false)
    var commonEntry = ValidatedInt(0, 10, -10, TEXTBOX_WITH_BUTTONS)
    @NonSync
    @ConfigGroup.Pop
    var clientEntry = true
}