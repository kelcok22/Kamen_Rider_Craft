package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class LowGravityEffect extends MobEffect {


	public LowGravityEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
			pLivingEntity.fallDistance=0;
		return true;
	}
}