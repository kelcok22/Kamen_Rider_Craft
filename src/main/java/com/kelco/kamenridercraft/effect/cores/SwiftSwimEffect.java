package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;


public class SwiftSwimEffect extends MobEffect {


	public SwiftSwimEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		if (pLivingEntity.isSwimming()) {
			if (!pLivingEntity.level().isClientSide()) {
				pLivingEntity.fallDistance = 0.0f;
				pLivingEntity.addDeltaMovement(pLivingEntity.getLookAngle().scale(0.1*(1+pAmplifier)));
				if ( pLivingEntity instanceof Player) {
					((Player)pLivingEntity).hurtMarked=true;
				}
				}	
			pLivingEntity.level().addParticle(ParticleTypes.BUBBLE,pLivingEntity.getX(), pLivingEntity.getY(),pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
			pLivingEntity.level().addParticle(ParticleTypes.BUBBLE,pLivingEntity.getX(), pLivingEntity.getY(),pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
			pLivingEntity.level().addParticle(ParticleTypes.BUBBLE,pLivingEntity.getX(), pLivingEntity.getY()+0.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
		
		}
		return true;
	}
}