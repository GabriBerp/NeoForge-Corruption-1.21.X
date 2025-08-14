package com.gabriberp.corruption.Entity.Custom;

import com.gabriberp.corruption.Entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SentinelEntity extends AbstractSentinel {
    protected static int SUMMON_COOLDOWN = 2400;
    protected static int SUMMON_QUANT = 5;
    protected int cont = 2400;

    public SentinelEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 20;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50d)
                .add(Attributes.MOVEMENT_SPEED, 0d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10d)
                .add(Attributes.ATTACK_DAMAGE, 0d)
                .add(Attributes.FOLLOW_RANGE, 128d);
    }

    @Override
    public void tick() {
        super.tick();

        if (hasValidTargetNearby(level(), this, 50.0)) {
            cont++;
            if (cont >= SUMMON_COOLDOWN){
                // Invoca SUMMON_QUANT criaturas
                for (int i = 0; i < SUMMON_QUANT; i++) {
                    // Cria a entidade
                    Mob entidade = ModEntities.CORRUPTION_BUG.get().create(level());

                    if (entidade != null) {
                        // Define posição próxima do mob atual
                        double offsetX = (random.nextDouble() - 0.5) * 4; // +- 2 blocos
                        double offsetZ = (random.nextDouble() - 0.5) * 4;
                        entidade.moveTo(this.getX() + offsetX, this.getY(), this.getZ() + offsetZ,
                                random.nextFloat() * 360F, 0F);

                        // Se quiser, já define o dono/alvo, etc.
                        // entidade.setTarget(alvo);

                        // Adiciona no mundo
                        level().addFreshEntity(entidade);
                    }
                }
                cont = 0;
            }
        }else{
            cont = SUMMON_COOLDOWN;
        }
    }
}
