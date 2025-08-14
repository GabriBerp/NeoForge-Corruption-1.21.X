package com.gabriberp.corruption.Item;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.ModEntities;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CorruptionMod.MOD_ID);

    public static final DeferredItem<Item> CORRUPTION_FRAGMENT = ITEMS.register("corruption_fragment",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CORRUPTED_GOLD_INGOT = ITEMS.register("corrupted_gold_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UMBRITIUM = ITEMS.register("umbritium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UMBRITIUM_NUGGET = ITEMS.register("umbritium_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OBSCURIUM = ITEMS.register("obscurium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SENTINEL_SPAWN_EGG = ITEMS.register("sentinel_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SENTINEL,0x3b003d, 0xb202b8,
                    new Item.Properties()));
    public static final DeferredItem<Item> CORRUPTION_EGG_SPAWN_EGG = ITEMS.register("corruption_egg_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SENTINEL_EGG,0x301e30, 0xa372a3,
                    new Item.Properties()));
    public static final DeferredItem<Item> CORRUPTION_BUG_SPAWN_EGG = ITEMS.register("corruption_bug_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.CORRUPTION_BUG,0xb329a2, 0xff82f0,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
