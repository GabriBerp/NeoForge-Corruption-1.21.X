package com.gabriberp.corruption.Entity.Custom;

import com.gabriberp.corruption.Entity.ModEntities;
import com.gabriberp.corruption.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CorruptionBugEntity extends Monster {
    public int KILL_COUNT = this.getPersistentData().getInt("KilledTargets");

    public CorruptionBugEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new CorruptionBugAttackGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.8));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F, 0.25F, false));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(
                this,
                LivingEntity.class, // Tipo de alvo
                true, // Deve verificar visibilidade
                entity -> {
                    // Não atacar ele mesmo
                    if (entity == this) return false;

                    // Não atacar mobs da mesma espécie
                    if (entity.getType() == this.getType()) return false;

                    // Não atacar mobs específicos
                    if (entity.getType() == ModEntities.SENTINEL.get()) return false;
                    if (entity.getType() == ModEntities.SENTINEL_MEDIUM.get()) return false;
                    if (entity.getType() == ModEntities.SENTINEL_SMALL.get()) return false;
                    if (entity.getType() == ModEntities.SENTINEL_EGG.get()) return false;
                    // Adicione mais linhas assim para outros mobs que não devem ser atacados

                    // Se passar por todas as checagens, ataca
                    return true;
                } // Filtro
        ));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, this.getClass()).setAlertOthers());
    }

    static class CorruptionBugAttackGoal extends MeleeAttackGoal {
        public CorruptionBugAttackGoal(CorruptionBugEntity bug) {
            super(bug, 1.4, true);
        }

        @Override
        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.FOLLOW_RANGE, 35.0);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    protected @NotNull PathNavigation createNavigation(Level level) {
        return new GroundPathNavigation(this, level);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean killedEntity(ServerLevel level, LivingEntity entity) {
        boolean flag = super.killedEntity(level, entity);

        // Obtém ou cria o contador de kills
        int kills = this.getPersistentData().getInt("KilledTargets");
        this.getPersistentData().putInt("KilledTargets", kills + 1);

        return flag;
    }
}
