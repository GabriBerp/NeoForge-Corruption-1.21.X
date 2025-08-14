package com.gabriberp.corruption.Datagen;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.Item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CORRUPTED_GOLD_BLOCK.get());
        dropSelf(ModBlocks.HANGING_CORRUPTION_ROOTS.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_BLOCK.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_SLAB.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_WALL.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_TILES.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_TILES_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_TILES_SLAB.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_TILES_WALL.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_BRICKS.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_BRICKS_SLAB.get());
        dropSelf(ModBlocks.POLISHED_AMETHYST_BRICKS_WALL.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_BRICKS.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_BRICKS_SLAB.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_BRICKS_WALL.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_BLOCK.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_SLAB.get());
        dropSelf(ModBlocks.POLISHED_CORRUPTION_WALL.get());

        add(ModBlocks.CORRUPTION_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.CORRUPTION_BLOCK.get(), ModItems.CORRUPTION_FRAGMENT.get(), 0, 2));

        add(ModBlocks.CRYING_CORRUPTION_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.CORRUPTION_BLOCK.get(), ModItems.CORRUPTION_FRAGMENT.get(), 2, 4));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
