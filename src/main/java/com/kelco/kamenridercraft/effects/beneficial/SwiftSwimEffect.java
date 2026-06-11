package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class SwiftSwimEffect extends MobEffect {


    public SwiftSwimEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

        if (livingEntity.isSwimming() && !livingEntity.level().isClientSide()) {
            livingEntity.fallDistance = 0.0f;
            livingEntity.addDeltaMovement(livingEntity.getLookAngle().scale(0.1 * (1 + amplifier)));

            if (livingEntity instanceof Player) {
                livingEntity.hurtMarked = true;
            }

            livingEntity.level().addParticle(ParticleTypes.BUBBLE, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 0.0D, 0.0D, 0.0D);
            livingEntity.level().addParticle(ParticleTypes.BUBBLE, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 0.0D, 0.0D, 0.0D);
            livingEntity.level().addParticle(ParticleTypes.BUBBLE, livingEntity.getX(), livingEntity.getY() + 0.5, livingEntity.getZ(), 0.0D, 0.0D, 0.0D);
        }
        return true;
    }
}