package com.gabriberp.corruption.Entity;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CorruptionMod.MOD_ID);


    public static final Supplier<EntityType<SentinelEntity>> SENTINEL =
            ENTITY_TYPES.register("sentinel",
                    () -> EntityType.Builder.of(SentinelEntity::new, MobCategory.MONSTER)
                            .sized(1.0f,3.25f)
                            .build("sentinel"));

    public static final Supplier<EntityType<SentinelMediumEntity>> SENTINEL_MEDIUM =
            ENTITY_TYPES.register("sentinel_medium",
                    () -> EntityType.Builder.of(SentinelMediumEntity::new, MobCategory.MONSTER)
                            .sized(1.0f,2.5f)
                            .build("sentinel_medium"));

    public static final Supplier<EntityType<SentinelSmallEntity>> SENTINEL_SMALL =
            ENTITY_TYPES.register("sentinel_small",
                    () -> EntityType.Builder.of(SentinelSmallEntity::new, MobCategory.MONSTER)
                            .sized(1.0f,1.35f)
                            .build("sentinel_small"));

    public static final Supplier<EntityType<SentinelEggEntity>> SENTINEL_EGG =
            ENTITY_TYPES.register("sentinel_egg",
                    () -> EntityType.Builder.of(SentinelEggEntity::new, MobCategory.MONSTER)
                            .sized(1.0f,1.0f)
                            .build("sentinel_egg"));

    public static final Supplier<EntityType<CorruptionBugEntity>> CORRUPTION_BUG =
            ENTITY_TYPES.register("corruption_bug",
                    () -> EntityType.Builder.of(CorruptionBugEntity::new, MobCategory.MONSTER)
                            .sized(1.25f,1.25f)
                            .build("corruption_bug"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
