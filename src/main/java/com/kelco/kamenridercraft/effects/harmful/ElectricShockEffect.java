package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class ElectricShockEffect extends MobEffect {

	public ElectricShockEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
		if (livingEntity.level() instanceof ServerLevel serverLevel) {
			livingEntity.hurt(livingEntity.damageSources().lightningBolt(), 1.0F);
			serverLevel.sendParticles(ModParticles.ELECTRIC_SPARK_PARTICLES.get(), livingEntity.getX(), livingEntity.getEyeY() - livingEntity.getScale() * 0.75, livingEntity.getZ(), 5, 0, 0, 0, 0);
		}
		return true;
	}

	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		int i = 40 >> amplifier;
		return i == 0 || tickCount % i == 0;
	}
}