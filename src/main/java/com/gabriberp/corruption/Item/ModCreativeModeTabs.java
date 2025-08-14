package com.gabriberp.corruption.Item;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.CorruptionMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CorruptionMod.MOD_ID);


    public static final Supplier<CreativeModeTab>  CORRUPTION_ITEMS_TAB = CREATIVE_MODE_TAB.register("corruption_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CORRUPTED_GOLD_INGOT.get()))
                    .title(Component.translatable("creativetab.corruption.corruption_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CORRUPTION_FRAGMENT);
                        output.accept(ModItems.CORRUPTED_GOLD_INGOT);
                        output.accept(ModItems.UMBRITIUM);
                        output.accept(ModItems.UMBRITIUM_NUGGET);
                        output.accept(ModItems.OBSCURIUM);
                    })

                    .build());

    public static final Supplier<CreativeModeTab>  CORRUPTION_BLOCKS_TAB = CREATIVE_MODE_TAB.register("corruption_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CORRUPTION_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "corruption_items_tab"))
                    .title(Component.translatable("creativetab.corruption.corruption_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CORRUPTION_BLOCK);
                        output.accept(ModBlocks.CRYING_CORRUPTION_BLOCK);
                        output.accept(ModBlocks.HANGING_CORRUPTION_ROOTS);
                        output.accept(ModBlocks.CORRUPTION_NUCLEUS);
                        output.accept(ModBlocks.BUDDING_CORRUPTION);
                        output.accept(ModBlocks.CORRUPTED_SCULK);
                        output.accept(ModBlocks.CORRUPTED_GOLD_BLOCK);
                        output.accept(ModBlocks.POLISHED_AMETHYST_BRICKS);
                        output.accept(ModBlocks.POLISHED_AMETHYST_BRICKS_SLAB);
                        output.accept(ModBlocks.POLISHED_AMETHYST_BRICKS_STAIRS);
                        output.accept(ModBlocks.POLISHED_AMETHYST_BRICKS_WALL);
                        output.accept(ModBlocks.POLISHED_AMETHYST_BLOCK);
                        output.accept(ModBlocks.POLISHED_AMETHYST_SLAB);
                        output.accept(ModBlocks.POLISHED_AMETHYST_STAIRS);
                        output.accept(ModBlocks.POLISHED_AMETHYST_WALL);
                        output.accept(ModBlocks.POLISHED_AMETHYST_TILES);
                        output.accept(ModBlocks.POLISHED_AMETHYST_TILES_SLAB);
                        output.accept(ModBlocks.POLISHED_AMETHYST_TILES_STAIRS);
                        output.accept(ModBlocks.POLISHED_AMETHYST_TILES_WALL);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_BRICKS);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_BRICKS_SLAB);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_BRICKS_STAIRS);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_BRICKS_WALL);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_BLOCK);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_SLAB);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_STAIRS);
                        output.accept(ModBlocks.POLISHED_CORRUPTION_WALL);
                    })

                    .build());

    public static final Supplier<CreativeModeTab>  CORRUPTION_MOBS_TAB = CREATIVE_MODE_TAB.register("corruption_mobs_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SENTINEL_SPAWN_EGG.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "corruption_blocks_tab"))
                    .title(Component.translatable("creativetab.corruption.corruption_mobs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SENTINEL_SPAWN_EGG);
                        output.accept(ModItems.CORRUPTION_EGG_SPAWN_EGG);
                        output.accept(ModItems.CORRUPTION_BUG_SPAWN_EGG);
                    })

                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
