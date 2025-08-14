package com.gabriberp.corruption.Block.custom;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.Entity.ModEntities;
import com.gabriberp.corruption.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CorruptionNucleusBlock extends Block {
    public CorruptionNucleusBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);

        // Pega vizinhos adjacentes (6 lados)
        for (Direction dir : Direction.values()) {
            BlockPos targetPos = pos.relative(dir);
            BlockState targetState = level.getBlockState(targetPos);

            if (ehBlocoValido(targetState) && random.nextFloat() < 0.45f + (0.25 * sentinelasProx(level, pos, 10))) {
                level.setBlock(targetPos, ModBlocks.CORRUPTED_SCULK.get().defaultBlockState(), 3);
            }
        }
    }

    private boolean ehBlocoValido(BlockState state) {
        return state.is(Blocks.GRASS_BLOCK) ||
                state.is(Blocks.DIRT) ||
                state.is(Blocks.COARSE_DIRT) ||
                state.is(Blocks.PODZOL) ||
                state.is(Blocks.MUD) ||
                state.is(Blocks.MOSS_BLOCK) ||
                state.is(Blocks.MYCELIUM) ||

                state.is(Blocks.STONE) ||
                state.is(Blocks.COBBLESTONE) ||
                state.is(Blocks.GRANITE) ||
                state.is(Blocks.DIORITE) ||
                state.is(Blocks.ANDESITE) ||
                state.is(Blocks.DEEPSLATE) ||
                state.is(Blocks.TUFF) ||
                state.is(Blocks.CALCITE) ||
                state.is(Blocks.DRIPSTONE_BLOCK) ||

                state.is(Blocks.GRAVEL) ||
                state.is(Blocks.SAND) ||
                state.is(Blocks.RED_SAND) ||
                state.is(Blocks.CLAY) ||

                state.is(Blocks.OBSIDIAN) ||
                state.is(Blocks.END_STONE) ||
                state.is(Blocks.NETHERRACK) ||
                state.is(Blocks.SOUL_SAND) ||
                state.is(Blocks.SOUL_SOIL) ||
                state.is(Blocks.BROWN_MUSHROOM_BLOCK) ||
                state.is(Blocks.RED_MUSHROOM_BLOCK) ||

                state.is(Blocks.DIRT_PATH) ||
                state.is(Blocks.ROOTED_DIRT) ||

                state.is(Blocks.BLACKSTONE) ||
                state.is(Blocks.GILDED_BLACKSTONE) ||
                state.is(Blocks.BASALT) ||
                state.is(Blocks.POLISHED_BASALT) ||

                state.is(Blocks.SMOOTH_STONE) ||
                state.is(Blocks.POLISHED_GRANITE) ||
                state.is(Blocks.POLISHED_DIORITE) ||
                state.is(Blocks.POLISHED_ANDESITE) ||

                state.is(Blocks.DEEPSLATE_BRICKS) ||
                state.is(Blocks.DEEPSLATE_TILES) ||

                state.is(Blocks.STONE_BRICKS) ||
                state.is(Blocks.MOSSY_STONE_BRICKS) ||
                state.is(Blocks.CRACKED_STONE_BRICKS) ||
                state.is(Blocks.CHISELED_STONE_BRICKS) ||

                state.is(Blocks.END_STONE_BRICKS) ||
                state.is(Blocks.PURPUR_BLOCK) ||
                state.is(Blocks.QUARTZ_BLOCK) ||

                state.is(Blocks.SMOOTH_QUARTZ) ||
                state.is(Blocks.NETHER_BRICKS) ||
                state.is(Blocks.RED_NETHER_BRICKS) ||
                state.is(Blocks.CHISELED_NETHER_BRICKS) ||
                state.is(Blocks.CRACKED_NETHER_BRICKS) ||

                state.is(Blocks.BONE_BLOCK) ||
                state.is(Blocks.CRYING_OBSIDIAN) ||
                state.is(Blocks.ANCIENT_DEBRIS);
    }

    int sentinelasProx(ServerLevel level, BlockPos pos, int maxDistance) {
        // rodar só no servidor — normalmente ServerLevel já é servidor, mas fica seguro
        if (level.isClientSide()) return 0;

        // caixa cúbica para busca rápida (ainda aplicaremos checagem esférica)
        AABB area = new AABB(
                pos.getX() - maxDistance, pos.getY() - maxDistance, pos.getZ() - maxDistance,
                pos.getX() + maxDistance + 1, pos.getY() + maxDistance + 1, pos.getZ() + maxDistance + 1
        );

        // Busca usando EntityType (evita precisar da Classe)
        List<? extends Entity> encontrados = level.getEntities(
                ModEntities.SENTINEL.get(),
                area,
                e -> {
                    // Só vivos
                    if (!e.isAlive()) return false;
                    // Checagem esférica real (evita contar entidades nas bordas do cubo)
                    double dx = e.getX() - (pos.getX() + 0.5);
                    double dy = e.getY() - (pos.getY() + 0.5);
                    double dz = e.getZ() - (pos.getZ() + 0.5);
                    return (dx*dx + dy*dy + dz*dz) <= (double)maxDistance * (double)maxDistance;
                }
        );
        return encontrados.size();
    }
}
