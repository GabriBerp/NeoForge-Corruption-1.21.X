package com.gabriberp.corruption.Datagen;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.CorruptionMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
        blockWithItem(ModBlocks.CRYING_CORRUPTION_BLOCK);
        blockWithItem(ModBlocks.CORRUPTED_SCULK);
        blockWithItem(ModBlocks.BUDDING_CORRUPTION);
        simpleBlockWithItem(ModBlocks.CORRUPTION_NUCLEUS.get(),models().getExistingFile(modLoc("block/corruption_nucleus")));
        crossBlockWithItem(ModBlocks.HANGING_CORRUPTION_ROOTS.get(), "hanging_corruption_roots");
        blockWithItem(ModBlocks.POLISHED_AMETHYST_BRICKS);
        blockWithItem(ModBlocks.POLISHED_AMETHYST_TILES);
        blockWithItem(ModBlocks.POLISHED_AMETHYST_BLOCK);
        blockWithItem(ModBlocks.POLISHED_CORRUPTION_BRICKS);
        blockWithItem(ModBlocks.POLISHED_CORRUPTION_BLOCK);

        stairsBlock(ModBlocks.POLISHED_AMETHYST_STAIRS.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BLOCK.get()));
        slabBlock(ModBlocks.POLISHED_AMETHYST_SLAB.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BLOCK.get()), blockTexture(ModBlocks.POLISHED_AMETHYST_BLOCK.get()));
        wallBlock(ModBlocks.POLISHED_AMETHYST_WALL.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BLOCK.get()));

        stairsBlock(ModBlocks.POLISHED_AMETHYST_BRICKS_STAIRS.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BRICKS.get()));
        slabBlock(ModBlocks.POLISHED_AMETHYST_BRICKS_SLAB.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BRICKS.get()), blockTexture(ModBlocks.POLISHED_AMETHYST_BRICKS.get()));
        wallBlock(ModBlocks.POLISHED_AMETHYST_BRICKS_WALL.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BRICKS.get()));

        stairsBlock(ModBlocks.POLISHED_AMETHYST_TILES_STAIRS.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_TILES.get()));
        slabBlock(ModBlocks.POLISHED_AMETHYST_TILES_SLAB.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_BLOCK.get()), blockTexture(ModBlocks.POLISHED_AMETHYST_TILES.get()));
        wallBlock(ModBlocks.POLISHED_AMETHYST_TILES_WALL.get(), blockTexture(ModBlocks.POLISHED_AMETHYST_TILES.get()));

        stairsBlock(ModBlocks.POLISHED_CORRUPTION_STAIRS.get(), blockTexture(ModBlocks.POLISHED_CORRUPTION_BLOCK.get()));
        slabBlock(ModBlocks.POLISHED_CORRUPTION_SLAB.get(), blockTexture(ModBlocks.POLISHED_CORRUPTION_BLOCK.get()), blockTexture(ModBlocks.POLISHED_CORRUPTION_BLOCK.get()));
        wallBlock(ModBlocks.POLISHED_CORRUPTION_WALL.get(), blockTexture(ModBlocks.POLISHED_CORRUPTION_BLOCK.get()));

        stairsBlock(ModBlocks.POLISHED_CORRUPTION_BRICKS_STAIRS.get(), blockTexture(ModBlocks.POLISHED_CORRUPTION_BRICKS.get()));
        slabBlock(ModBlocks.POLISHED_CORRUPTION_BRICKS_SLAB.get(), blockTexture(ModBlocks.POLISHED_CORRUPTION_BRICKS.get()), blockTexture(ModBlocks.POLISHED_CORRUPTION_BRICKS.get()));
        wallBlock(ModBlocks.POLISHED_CORRUPTION_BRICKS_WALL.get(), blockTexture(ModBlocks.POLISHED_CORRUPTION_BRICKS.get()));

        blockItem(ModBlocks.POLISHED_AMETHYST_STAIRS);
        blockItem(ModBlocks.POLISHED_AMETHYST_SLAB);
        blockItem(ModBlocks.POLISHED_AMETHYST_WALL);
        blockItem(ModBlocks.POLISHED_AMETHYST_BRICKS_STAIRS);
        blockItem(ModBlocks.POLISHED_AMETHYST_BRICKS_SLAB);
        blockItem(ModBlocks.POLISHED_AMETHYST_BRICKS_WALL);
        blockItem(ModBlocks.POLISHED_AMETHYST_TILES_STAIRS);
        blockItem(ModBlocks.POLISHED_AMETHYST_TILES_SLAB);
        blockItem(ModBlocks.POLISHED_AMETHYST_TILES_WALL);
        blockItem(ModBlocks.POLISHED_CORRUPTION_STAIRS);
        blockItem(ModBlocks.POLISHED_CORRUPTION_SLAB);
        blockItem(ModBlocks.POLISHED_CORRUPTION_WALL);
        blockItem(ModBlocks.POLISHED_CORRUPTION_BRICKS_STAIRS);
        blockItem(ModBlocks.POLISHED_CORRUPTION_BRICKS_SLAB);
        blockItem(ModBlocks.POLISHED_CORRUPTION_BRICKS_WALL);


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("corruption:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("corruption:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void crossBlockWithItem(Block block, String textureName) {
        simpleBlockWithItem(
                block,
                models().cross(
                        textureName,
                        modLoc("block/" + textureName)
                ).renderType("cutout")
        );
    }

    private String name(DeferredBlock<?> block) {
        return block.getId().getPath();
    }
}
