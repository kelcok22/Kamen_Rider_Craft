package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;


public class NoteEffect extends InstantenousMobEffect {


	public NoteEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
						pLivingEntity.level().addParticle(ParticleTypes.NOTE,pLivingEntity.getX(), pLivingEntity.getY()+1.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);

		Random generator = new Random();
		int rand = generator.nextInt(10);
						pLivingEntity.level().playLocalSound(pLivingEntity, SoundEvents.PIG_STEP, SoundSource.RECORDS, 1,  rand) ;

		return true;
	}
}


