package com.kelco.kamenridercraft.effect.cores;


import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;


public class SaveEffect extends MobEffect {


	public SaveEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {

			pLivingEntity.removeEffect(MobEffects.POISON);
			pLivingEntity.removeEffect(MobEffects.BLINDNESS);
			pLivingEntity.removeEffect(MobEffects.DARKNESS);
			pLivingEntity.removeEffect(MobEffects.DIG_SLOWDOWN);
			pLivingEntity.removeEffect(MobEffects.HARM);
			pLivingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			pLivingEntity.removeEffect(MobEffects.WEAKNESS);
			pLivingEntity.removeEffect(MobEffects.WITHER);
			pLivingEntity.removeEffect(Effect_core.EXPLODE);
			pLivingEntity.removeEffect(Effect_core.RESET);
			pLivingEntity.removeEffect(Effect_core.PAUSE);
			pLivingEntity.removeEffect(Effect_core.FORM_LOCK);

		}
		return true;
	}
}