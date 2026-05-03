package com.kelco.kamenridercraft.effects;


import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
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
			pLivingEntity.removeEffect(EffectCore.EXPLODE);
			pLivingEntity.removeEffect(EffectCore.RESET);
			pLivingEntity.removeEffect(EffectCore.PAUSE);
			pLivingEntity.removeEffect(EffectCore.FORM_LOCK);

		}
		return true;
	}
}