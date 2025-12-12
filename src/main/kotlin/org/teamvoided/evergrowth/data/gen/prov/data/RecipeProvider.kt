package org.teamvoided.evergrowth.data.gen.prov.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeBuilder
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapedRecipeBuilder.shaped
import net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless
import net.minecraft.tags.TagKey
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.ItemLike
import org.teamvoided.evergrowth.Evergrowth.cast
import org.teamvoided.evergrowth.init.EverBlocks
import org.teamvoided.evergrowth.init.EverItems
import org.teamvoided.evergrowth.init.helpers.EverBlockFamilies
import java.util.concurrent.CompletableFuture

class RecipeProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(o, r) {
    override fun buildRecipes(e: RecipeOutput) {
        shaped(RecipeCategory.BUILDING_BLOCKS, EverBlocks.HOLYSTONE, 2)
            .pattern("#B")
            .pattern("C#")
            .defineUnlockedBy('#', Items.QUARTZ)
            .defineUnlockedBy('B', EverItems.HOLY_BLOOD)
            .defineUnlockedBy('C', Items.CALCITE)
            .save(e)
        generateRecipes(e, EverBlockFamilies.HOLYSTONE_TILES, FeatureFlags.VANILLA_SET)

        shaped(RecipeCategory.BUILDING_BLOCKS, EverBlocks.HOLY_LANTERN)
            .pattern(" # ")
            .pattern("#H#")
            .pattern("#B#")
            .defineUnlockedBy('#', Items.GOLD_NUGGET)
            .defineUnlockedBy('H', EverItems.HOLY_BLOOD)
            .define('B', Items.BLAZE_POWDER)
            .save(e)


        // Folly Red Glass
        shapeless(RecipeCategory.BUILDING_BLOCKS, EverBlocks.FOLLY_RED_GLASS)
            .requires(Items.GLASS)
            .requires(EverItems.STRAWBERRY)
            .unlockedBy(EverItems.STRAWBERRY)
            .save(e)
        shaped(RecipeCategory.BUILDING_BLOCKS, EverBlocks.FOLLY_RED_GLASS_PANE, 16)
            .pattern("###")
            .pattern("###")
            .defineUnlockedBy('#', EverBlocks.FOLLY_RED_GLASS)
            .save(e)

        shaped(RecipeCategory.COMBAT, EverItems.ATHAME)
            .pattern("  #")
            .pattern(" # ")
            .pattern("S  ")
            .defineUnlockedBy('#', Items.QUARTZ)
            .defineUnlockedBy('S', Items.STICK)
            .save(e)

        shapeless(RecipeCategory.FOOD, EverItems.STRAWBERRY_JAM)
            .requires(EverItems.STRAWBERRY)
            .requires(Items.SUGAR)
            .requires(Items.GLASS_BOTTLE)
            .unlockedBy(EverItems.STRAWBERRY)
            .save(e)
        shapeless(RecipeCategory.FOOD, EverItems.STRAWBERRY_TOAST)
            .requires(EverItems.STRAWBERRY)
            .requires(Items.BREAD)
            .unlockedBy(EverItems.STRAWBERRY)
            .save(e)


        shaped(RecipeCategory.FOOD, EverItems.RED40)
            .pattern("RSG")
            .pattern(" B ")
            .defineUnlockedBy('R', Items.RED_DYE)
            .defineUnlockedBy('S', EverItems.STRAWBERRY)
            .defineUnlockedBy('G', Items.GOLDEN_APPLE)
            .defineUnlockedBy('B', Items.GLASS_BOTTLE)
            .save(e)

        shaped(RecipeCategory.MISC, EverItems.HEART_OF_THE_HARVEST)
            .pattern("GHG")
            .pattern("HRH")
            .pattern("GHG")
            .defineUnlockedBy('R', EverItems.RED40)
            .defineUnlockedBy('H', EverItems.HOLY_BLOOD)
            .defineUnlockedBy('G', Items.GOLD_BLOCK)
            .save(e)

        shaped(RecipeCategory.TOOLS, EverItems.ALTALUNE)
            .pattern("  S")
            .pattern("GH ")
            .pattern("BG ")
            .defineUnlockedBy('S', EverBlocks.HOLYSTONE)
            .defineUnlockedBy('H', EverItems.HEART_OF_THE_HARVEST)
            .defineUnlockedBy('G', Items.GOLD_INGOT)
            .defineUnlockedBy('B', Items.BREEZE_ROD)
            .save(e)

        shaped(RecipeCategory.TOOLS, EverItems.SOLANUM)
            .pattern("S")
            .pattern("H")
            .pattern("B")
            .defineUnlockedBy('S', EverBlocks.HOLYSTONE)
            .defineUnlockedBy('H', EverItems.HEART_OF_THE_HARVEST)
            .defineUnlockedBy('B', Items.BLAZE_ROD)
            .save(e)

        shaped(RecipeCategory.MISC, EverItems.MEOW_DISC)
            .pattern(" S ")
            .pattern("GHG")
            .pattern(" G ")
            .defineUnlockedBy('S', EverItems.STRAWBERRY)
            .defineUnlockedBy('H', EverItems.HEART_OF_THE_HARVEST)
            .defineUnlockedBy('G', Items.GOLD_INGOT)
            .save(e)
    }


    // lib stuff
    fun ShapedRecipeBuilder.defineUnlockedBy(c: Char, item: ItemLike): ShapedRecipeBuilder =
        define(c, item).unlockedBy(item)

    fun ShapedRecipeBuilder.defineUnlockedBy(c: Char, tag: TagKey<Item>): ShapedRecipeBuilder =
        define(c, tag).unlockedBy(tag)

    inline fun <reified T : RecipeBuilder> T.unlockedBy(item: ItemLike): T =
        unlockedBy(getHasName(item), has(item)).cast<T>()

    inline fun <reified T : RecipeBuilder> T.unlockedBy(tag: TagKey<Item>): T =
        unlockedBy("has_${tag.location.path}", has(tag)).cast<T>()
}