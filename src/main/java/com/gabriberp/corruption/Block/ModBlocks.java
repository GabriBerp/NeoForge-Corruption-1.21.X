package com.gabriberp.corruption.Block;

import com.gabriberp.corruption.Block.custom.BuddingCorruptionBlock;
import com.gabriberp.corruption.Block.custom.CorruptedSculkBlock;
import com.gabriberp.corruption.Block.custom.CorruptionBlock;
import com.gabriberp.corruption.Block.custom.CorruptionNucleusBlock;
import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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
                    .strength(25.0F,1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SCULK)));

    public static final DeferredBlock<Block> CORRUPTED_SCULK = registerBlock("corrupted_sculk",
            () -> new CorruptedSculkBlock(BlockBehaviour.Properties.of()
                    .strength(1.5F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .randomTicks()
                    .noLootTable()
                    .sound(SoundType.SCULK)));

    public static final DeferredBlock<Block> BUDDING_CORRUPTION = registerBlock("budding_corruption",
            () -> new BuddingCorruptionBlock(BlockBehaviour.Properties.of()
                    .strength(25.0F,1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .noLootTable()
                    .randomTicks()
                    .sound(SoundType.SCULK)
                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> CORRUPTION_NUCLEUS = registerBlock("corruption_nucleus",
            () -> new CorruptionNucleusBlock(BlockBehaviour.Properties.of()
                    .strength(50.0F,1200.0F)
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
