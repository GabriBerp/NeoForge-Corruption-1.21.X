package com.gabriberp.corruption.util;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Custom.AbstractSentinel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INFECTABLE_BLOCKS =
                BlockTags.create(ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "infectable_blocks"));
    }

    public static class Items {

    }

    public static class Entities {
        public static final TagKey<EntityType<?>> SENTINEL_ENTITY =
                TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "sentinel_entity"));

        public static final TagKey<EntityType<?>> CORRUPTION_MOBS =
                TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "corruption_mobs"));
    }
}