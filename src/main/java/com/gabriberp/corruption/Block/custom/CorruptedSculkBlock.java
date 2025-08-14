package com.gabriberp.corruption.Block.custom;

import com.gabriberp.corruption.Block.ModBlocks;
import com.gabriberp.corruption.Entity.ModEntities;
import com.gabriberp.corruption.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.*;

public class CorruptedSculkBlock extends Block {
    public CorruptedSculkBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        float porc = (float) (0.25 + (0.25 * sentinelasProx(level, pos, 10)));

        // Verifica se está conectado a um CorruptionNucleus dentro de raio 5
        if (!estaConectadoANucleus(level, pos, 5 + (sentinelasProx(level, pos, 10))) || (sentinelasProx(level, pos, 10)) >= 1) {
            return; // Não está conectado, não propaga nem transforma
        }

        // Tenta infectar blocos adjacentes válidos
        for (Direction dir : Direction.values()) {
            BlockPos targetPos = pos.relative(dir);
            BlockState targetState = level.getBlockState(targetPos);

            if (ehBlocoValido(targetState) && random.nextFloat() < porc) {
                level.setBlock(targetPos, ModBlocks.CORRUPTED_SCULK.get().defaultBlockState(), 3);
            }
        }

        // Conta quantos corrupted_sculk estão por perto (raio 3)
        int count = 0;
        for (BlockPos checkPos : BlockPos.betweenClosed(pos.offset(-3, -3, -3), pos.offset(3, 3, 3))) {
            if ((level.getBlockState(checkPos).is(ModBlocks.CORRUPTED_SCULK.get()))) {
                count++;
            }
        }

        // Se >= 7, transforma em budding_corruption ou corruption_block
        if (count >= 7) {
            float chanc = random.nextFloat();
            if (chanc < 0.25f) {
                level.setBlock(pos, ModBlocks.BUDDING_CORRUPTION.get().defaultBlockState(), 3);
            } else {
                if (chanc < 0.5f){
                    if (level.getBlockState(pos.below()).isAir()){
                        chanc = random.nextFloat();
                        level.setBlock(pos, ModBlocks.CRYING_CORRUPTION_BLOCK.get().defaultBlockState(), 3);
                        if (chanc < 0.5f) {
                            level.setBlock(pos.below(), ModBlocks.HANGING_CORRUPTION_ROOTS.get().defaultBlockState(), 3);
                        }
                    }else{
                        level.setBlock(pos, ModBlocks.CRYING_CORRUPTION_BLOCK.get().defaultBlockState(), 3);
                    }
                } else {
                    chanc = random.nextFloat();
                    level.setBlock(pos, ModBlocks.CORRUPTION_BLOCK.get().defaultBlockState(), 3);
                    // 0.025% de chance de colocar um nucleus encima do bloco transformado (se o bloco for ar)
                    if (chanc < 0.025f && level.getBlockState(pos.above()).isAir()) {
                        level.setBlock(pos.above(), ModBlocks.CORRUPTION_NUCLEUS.get().defaultBlockState(), 3);
                    } else {
                        // Caso não consiga colocar o nucleus, tenta spawnar o SENTINEL_EGG
                        if (chanc < 0.05f && level.getBlockState(pos.above()).isAir()) {
                            var eggEntity = ModEntities.SENTINEL_EGG.get().create(level);
                            if (eggEntity != null) {
                                eggEntity.setPos(
                                        pos.getX() + 0.5, // Centraliza no bloco
                                        pos.getY() + 1,   // Em cima do bloco
                                        pos.getZ() + 0.5
                                );
                                level.addFreshEntity(eggEntity);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean ehBlocoValido(BlockState state) {
        return state.is(ModTags.Blocks.INFECTABLE_BLOCKS);
    }

    boolean estaConectadoANucleus(ServerLevel level, BlockPos startPos, int maxDistance) {
        Set<BlockPos> visitados = new HashSet<>();
        Queue<BlockPos> fila = new LinkedList<>();
        fila.add(startPos);
        visitados.add(startPos);

        while (!fila.isEmpty()) {
            BlockPos pos = fila.poll();

            if (pos.distSqr(startPos) > maxDistance * maxDistance) continue;

            BlockState state = level.getBlockState(pos);

            if (state.is(ModBlocks.CORRUPTION_NUCLEUS.get())) {
                return true; // Encontrou o núcleo, conectado
            }

            if (state.is(ModBlocks.CORRUPTED_SCULK.get()) || state.is(ModBlocks.CORRUPTION_BLOCK.get()) || state.is(ModBlocks.BUDDING_CORRUPTION.get())) {
                for (Direction dir : Direction.values()) {
                    BlockPos vizinho = pos.relative(dir);
                    if (!visitados.contains(vizinho)) {
                        fila.add(vizinho);
                        visitados.add(vizinho);
                    }
                }
            }
        }
        return false; // Não achou nucleus conectado dentro do alcance
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
