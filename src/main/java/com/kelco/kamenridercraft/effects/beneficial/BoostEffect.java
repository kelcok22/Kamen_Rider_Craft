package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;


public class BoostEffect extends MobEffect {


    public BoostEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int pAmplifier) {
        if (livingEntity.isCrouching() && livingEntity.level() instanceof ServerLevel serverLevel) {
            Vec3 look = new Vec3(livingEntity.getLookAngle().x * 0.1, livingEntity.getLookAngle().y * 0.04, livingEntity.getLookAngle().z * 0.1).scale(1 + pAmplifier);
            livingEntity.push(look.x, look.y + livingEntity.getGravity(), look.z);

            livingEntity.hurtMarked = true;
            livingEntity.fallDistance = 0.0f;

            serverLevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 5, 0, 0, 0, 0);
        }
        return true;
    }
}