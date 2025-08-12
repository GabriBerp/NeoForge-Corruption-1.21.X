package com.gabriberp.corruption.Entity.Custom;

import com.gabriberp.corruption.Entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SentinelEggEntity extends AbstractSentinel {

    public SentinelEggEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 5;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5d)
                .add(Attributes.MOVEMENT_SPEED, 0d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10d)
                .add(Attributes.ATTACK_DAMAGE, 0d)
                .add(Attributes.FOLLOW_RANGE, 128d);
    }

    @Override
    public void tick() {
        super.tick();

        if ((this.tickCount > 6000) && (contarVirus(5, 10))) {
            SentinelSmallEntity novo = ModEntities.SENTINEL_SMALL.get().create(level());
            if (novo != null) {
                novo.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
                this.discard();
                level().addFreshEntity(novo);
            }
        }
    }
}
