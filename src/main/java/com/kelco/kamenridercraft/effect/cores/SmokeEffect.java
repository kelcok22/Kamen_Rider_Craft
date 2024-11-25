package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class SmokeEffect extends InstantenousMobEffect {


	public SmokeEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

						pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+1.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
						pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+1,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
						pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+0.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);

		return true;
	}
}


