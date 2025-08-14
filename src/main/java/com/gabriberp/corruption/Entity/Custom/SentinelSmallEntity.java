package com.gabriberp.corruption.Entity.Custom;

import com.gabriberp.corruption.Entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SentinelSmallEntity extends AbstractSentinel {
    protected static int SUMMON_COOLDOWN = 1200;
    protected static int SUMMON_QUANT = 1;
    protected int cont = 1200;

    public SentinelSmallEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 10;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 15d)
                .add(Attributes.MOVEMENT_SPEED, 0d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10d)
                .add(Attributes.ATTACK_DAMAGE, 0d)
                .add(Attributes.FOLLOW_RANGE, 128d);
    }

    @Override
    public void tick() {
        super.tick();

        if ((this.tickCount > 6000) && (contarVirus(10, 15))) {
            SentinelMediumEntity novo = ModEntities.SENTINEL_MEDIUM.get().create(level());
            if (novo != null) {
                novo.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
                this.discard();
                level().addFreshEntity(novo);
            }
        }

        if (hasValidTargetNearby(level(), this, 15.0)) {
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
