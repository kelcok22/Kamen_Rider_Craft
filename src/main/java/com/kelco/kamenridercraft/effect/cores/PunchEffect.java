package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;


public class PunchEffect extends MobEffect {


	public PunchEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {

			if (pLivingEntity.getMainHandItem().isEmpty()) {
				pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, pAmplifier+3,false,false));
			}


		}
		return true;
	}
}