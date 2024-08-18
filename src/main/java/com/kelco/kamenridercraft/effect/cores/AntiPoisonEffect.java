package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;


public class AntiPoisonEffect extends MobEffect {


	public AntiPoisonEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
	 if (!pLivingEntity.level().isClientSide()) {
			pLivingEntity.removeEffect(MobEffects.POISON);
	}
		return true;
	 }

}