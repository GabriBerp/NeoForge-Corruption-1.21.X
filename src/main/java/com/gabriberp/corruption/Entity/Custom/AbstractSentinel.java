package com.gabriberp.corruption.Entity.Custom;

import com.gabriberp.corruption.Block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AbstractSentinel extends Monster {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    protected AbstractSentinel(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F, 0.25F, false));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, this.getClass()).setAlertOthers());
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 60;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    public boolean contarVirus(int reqNum, int maxDistance) {
        int count = 0;
        BlockPos center = this.blockPosition();

        // Varre todos os blocos no raio cúbico especificado
        for (BlockPos checkPos : BlockPos.betweenClosed(
                center.offset(-maxDistance, -maxDistance, -maxDistance),
                center.offset(maxDistance, maxDistance, maxDistance))) {

            if (level().getBlockState(checkPos).is(ModBlocks.CORRUPTED_SCULK.get())
                    || level().getBlockState(checkPos).is(ModBlocks.CORRUPTION_BLOCK.get())
                    || level().getBlockState(checkPos).is(ModBlocks.BUDDING_CORRUPTION.get())) {
                count++;
                if (count >= reqNum) {
                    return true; // já atingiu o número necessário
                }
            }
        }

        return false; // não encontrou blocos suficientes
    }
}
