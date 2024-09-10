package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SleepEffect extends InstantenousMobEffect {

	public SleepEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
		     if (pLivingEntity.level() instanceof ServerLevel ) {
		         ((ServerLevel)pLivingEntity.level()).setDayTime(0);
		      }
		}
		return false;
	}
}