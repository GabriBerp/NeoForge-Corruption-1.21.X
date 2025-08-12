package com.gabriberp.corruption.util;

import com.gabriberp.corruption.CorruptionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INFECTABLE_BLOCKS =
                TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "infectable_blocks"));
    }
}