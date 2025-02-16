package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;


public class BoostEffect extends MobEffect {


	public BoostEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		if (pLivingEntity.isCrouching()) {
			if (!pLivingEntity.level().isClientSide()) {
				pLivingEntity.fallDistance = 0.0f;
				Vec3 look = new Vec3(pLivingEntity.getLookAngle().x*0.1, pLivingEntity.getLookAngle().y*0.04, pLivingEntity.getLookAngle().z*0.1).scale(1+pAmplifier);
				pLivingEntity.push(look.x, look.y+pLivingEntity.getGravity(), look.z);
				if ( pLivingEntity instanceof Player player) player.hurtMarked=true;
			}
			pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY(),pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
			pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+1,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
			pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+0.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
		
		}
		return true;
	}
}