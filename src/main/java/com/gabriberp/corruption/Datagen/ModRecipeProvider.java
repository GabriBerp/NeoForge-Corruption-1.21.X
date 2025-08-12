package com.gabriberp.corruption.Datagen;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CORRUPTED_GOLD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.CORRUPTED_GOLD_INGOT.get())
                .unlockedBy("has_corrupted_gold", has(ModItems.CORRUPTED_GOLD_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CORRUPTION_BLOCK.get())
                .pattern("BX ")
                .pattern("XB ")
                .define('B', ModItems.CORRUPTION_FRAGMENT.get())
                .define('X', Items.SCULK)
                .unlockedBy("has_corrupted_gold", has(ModItems.CORRUPTED_GOLD_INGOT)).save(recipeOutput);

        // Crafting Corrupted Gold Ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CORRUPTED_GOLD_INGOT.get(), 1)
                .requires(ModItems.CORRUPTION_FRAGMENT)
                .requires(Items.GOLD_INGOT)
                .requires(ModItems.CORRUPTION_FRAGMENT)
                .requires(Items.GOLD_INGOT)
                .requires(ModItems.CORRUPTION_FRAGMENT)
                .requires(Items.GOLD_INGOT)
                .requires(ModItems.CORRUPTION_FRAGMENT)
                .requires(Items.GOLD_INGOT)
                .unlockedBy("has_corruption_fragment", has(ModItems.CORRUPTION_FRAGMENT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CORRUPTED_GOLD_INGOT.get(), 9)
                .requires(ModBlocks.CORRUPTED_GOLD_BLOCK)
                .unlockedBy("has_corrupted_gold_block", has(ModBlocks.CORRUPTED_GOLD_BLOCK))
                .save(recipeOutput,"corruption:corrupted_gold_block_to_ingot");

        // Crafting Umbritium
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UMBRITIUM.get())
                .pattern("BXB")
                .pattern("XBX")
                .pattern("BXB")
                .define('B', Items.ECHO_SHARD)
                .define('X', ModItems.CORRUPTION_FRAGMENT.get())
                .unlockedBy("has_corruption_fragment", has(ModItems.CORRUPTION_FRAGMENT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.UMBRITIUM_NUGGET.get(), 9)
                .requires(ModItems.UMBRITIUM)
                .unlockedBy("has_umbritium", has(ModItems.UMBRITIUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UMBRITIUM.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.UMBRITIUM_NUGGET.get())
                .unlockedBy("has_umbritium_nugget", has(ModItems.UMBRITIUM_NUGGET))
                .save(recipeOutput,"corruption:nugget_to_umbritium");

        // Crafting Obscurium
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBSCURIUM.get())
                .pattern("BXB")
                .pattern("XCX")
                .pattern("BXB")
                .define('B', Items.NETHERITE_INGOT)
                .define('C', ModItems.CORRUPTED_GOLD_INGOT.get())
                .define('X', ModItems.CORRUPTION_FRAGMENT.get())
                .unlockedBy("has_corruption_fragment", has(ModItems.CORRUPTION_FRAGMENT)).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {

    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {

    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CorruptionMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
