package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;


public class GhostEffect extends MobEffect {


	public GhostEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		if(pLivingEntity instanceof Player player){
			player.getFoodData().setFoodLevel(20);
		pLivingEntity.fallDistance = 0.0f;

		if (pLivingEntity.isCrouching()) {
			if (!pLivingEntity.level().isClientSide()) {
				pLivingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, pAmplifier, false, false));

			}
				}
		}
		return true;
	}
}