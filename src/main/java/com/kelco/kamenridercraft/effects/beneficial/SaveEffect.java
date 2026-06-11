package com.kelco.kamenridercraft.effects.beneficial;


import com.kelco.kamenridercraft.effects.EffectCore;
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
	public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
		if (!livingEntity.level().isClientSide()) {
			livingEntity.removeEffect(MobEffects.POISON);
			livingEntity.removeEffect(MobEffects.BLINDNESS);
			livingEntity.removeEffect(MobEffects.DARKNESS);
			livingEntity.removeEffect(MobEffects.DIG_SLOWDOWN);
			livingEntity.removeEffect(MobEffects.HARM);
			livingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			livingEntity.removeEffect(MobEffects.WEAKNESS);
			livingEntity.removeEffect(MobEffects.WITHER);
			livingEntity.removeEffect(EffectCore.EXPLODE);
			livingEntity.removeEffect(EffectCore.RESET);
			livingEntity.removeEffect(EffectCore.PAUSE);
			livingEntity.removeEffect(EffectCore.FORM_LOCK);
		}
		return true;
	}
}