package com.kelco.kamenridercraft.effects.neutral;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class SmokeEffect extends InstantenousMobEffect {


    public SmokeEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, livingEntity.getX(), livingEntity.getY() + 1.5, livingEntity.getZ(), 1, 0, 0, 0, 0);
            serverLevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, livingEntity.getX(), livingEntity.getY() + 1, livingEntity.getZ(), 1, 0, 0, 0, 0);
            serverLevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, livingEntity.getX(), livingEntity.getY() + 0.5, livingEntity.getZ(), 1, 0, 0, 0, 0);
        }
        return true;
    }
}


