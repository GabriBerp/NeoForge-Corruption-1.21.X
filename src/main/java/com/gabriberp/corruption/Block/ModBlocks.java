package com.gabriberp.corruption.Block;

import com.gabriberp.corruption.Block.custom.*;
import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CorruptionMod.MOD_ID);


    public static final DeferredBlock<Block> CORRUPTION_BLOCK = registerBlock("corruption_block",
            () -> new CorruptionBlock(BlockBehaviour.Properties.of()
                    .strength(15.0F,1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SCULK)));

    public static final DeferredBlock<Block> CRYING_CORRUPTION_BLOCK = registerBlock("crying_corruption_block",
            () -> new CryingCorruptionBlock(BlockBehaviour.Properties.of()
                    .strength(15.0F,1200.0F)
                    .lightLevel(state -> 5)
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SCULK)));

    public static final DeferredBlock<Block> CORRUPTED_SCULK = registerBlock("corrupted_sculk",
            () -> new CorruptedSculkBlock(BlockBehaviour.Properties.of()
                    .strength(5.5F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .randomTicks()
                    .noLootTable()
                    .sound(SoundType.SCULK)));

    public static final DeferredBlock<Block> BUDDING_CORRUPTION = registerBlock("budding_corruption",
            () -> new BuddingCorruptionBlock(BlockBehaviour.Properties.of()
                    .strength(15.0F,1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .noLootTable()
                    .randomTicks()
                    .sound(SoundType.SCULK)
                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> CORRUPTION_NUCLEUS = registerBlock("corruption_nucleus",
            () -> new CorruptionNucleusBlock(BlockBehaviour.Properties.of()
                    .strength(25.0F,1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .noLootTable()
                    .randomTicks()
                    .sound(SoundType.SCULK)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()));

    public static final DeferredBlock<Block> CORRUPTED_GOLD_BLOCK = registerBlock("corrupted_gold_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.COLOR_YELLOW)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> POLISHED_CORRUPTION_BRICKS = registerBlock("polished_corruption_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_TILES)));

    public static final DeferredBlock<Block> POLISHED_AMETHYST_BRICKS = registerBlock("polished_amethyst_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.COLOR_PINK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_TILES)));

    public static final DeferredBlock<Block> POLISHED_AMETHYST_TILES = registerBlock("polished_amethyst_tiles",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.COLOR_PINK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_TILES)));

    public static final DeferredBlock<Block> POLISHED_CORRUPTION_BLOCK = registerBlock("polished_corruption_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE_BRICKS)));

    public static final DeferredBlock<Block> POLISHED_AMETHYST_BLOCK = registerBlock("polished_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.COLOR_PINK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> HANGING_CORRUPTION_ROOTS = registerBlock("hanging_corruption_roots",
            () -> new HangingCorruptionRootsBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .emissiveRendering((state, level, pos) -> true)
                    .lightLevel(state -> 10)
                    .instabreak()
                    .noCollission()
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.SCULK)));

    public static final DeferredBlock<StairBlock> POLISHED_CORRUPTION_STAIRS = registerBlock("polished_corruption_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_CORRUPTION_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> POLISHED_CORRUPTION_SLAB = registerBlock("polished_corruption_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> POLISHED_CORRUPTION_WALL = registerBlock("polished_corruption_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> POLISHED_CORRUPTION_BRICKS_STAIRS = registerBlock("polished_corruption_bricks_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_CORRUPTION_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> POLISHED_CORRUPTION_BRICKS_SLAB = registerBlock("polished_corruption_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> POLISHED_CORRUPTION_BRICKS_WALL = registerBlock("polished_corruption_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<StairBlock> POLISHED_AMETHYST_STAIRS = registerBlock("polished_amethyst_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_AMETHYST_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> POLISHED_AMETHYST_SLAB = registerBlock("polished_amethyst_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> POLISHED_AMETHYST_WALL = registerBlock("polished_amethyst_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> POLISHED_AMETHYST_BRICKS_STAIRS = registerBlock("polished_amethyst_bricks_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_AMETHYST_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> POLISHED_AMETHYST_BRICKS_SLAB = registerBlock("polished_amethyst_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> POLISHED_AMETHYST_BRICKS_WALL = registerBlock("polished_amethyst_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> POLISHED_AMETHYST_TILES_STAIRS = registerBlock("polished_amethyst_tiles_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_AMETHYST_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> POLISHED_AMETHYST_TILES_SLAB = registerBlock("polished_amethyst_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> POLISHED_AMETHYST_TILES_WALL = registerBlock("polished_amethyst_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
