package com.gabriberp.corruption.Datagen;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.CorruptionMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CorruptionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CORRUPTION_BLOCK.get())
                .add(ModBlocks.CRYING_CORRUPTION_BLOCK.get())
                .add(ModBlocks.CORRUPTED_GOLD_BLOCK.get())
                .add(ModBlocks.BUDDING_CORRUPTION.get())
                .add(ModBlocks.CORRUPTION_NUCLEUS.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.CORRUPTED_SCULK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CORRUPTED_SCULK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CORRUPTION_BLOCK.get())
                .add(ModBlocks.CRYING_CORRUPTION_BLOCK.get())
                .add(ModBlocks.CORRUPTED_GOLD_BLOCK.get())
                .add(ModBlocks.BUDDING_CORRUPTION.get())
                .add(ModBlocks.CORRUPTION_NUCLEUS.get());

    }
}
