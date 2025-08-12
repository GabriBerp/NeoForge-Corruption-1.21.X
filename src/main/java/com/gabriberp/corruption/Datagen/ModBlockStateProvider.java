package com.gabriberp.corruption.Datagen;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.CorruptionMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CorruptionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.CORRUPTED_GOLD_BLOCK);

        blockWithItem(ModBlocks.CORRUPTION_BLOCK);
        blockWithItem(ModBlocks.CORRUPTED_SCULK);
        blockWithItem(ModBlocks.BUDDING_CORRUPTION);
        simpleBlockWithItem(ModBlocks.CORRUPTION_NUCLEUS.get(),models().getExistingFile(modLoc("block/corruption_nucleus")));


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
