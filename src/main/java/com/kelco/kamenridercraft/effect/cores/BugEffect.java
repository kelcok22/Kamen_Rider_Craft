package com.kelco.kamenridercraft.effect.cores;

import java.util.Random;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class BugEffect extends MobEffect {


	public BugEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}
	/**
	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		//BaseHenchmenEntity boss  =   MobsCore.BUGSTERVIRUS.get().create(pLivingEntity.level());
		Random rand = new Random();


		
		switch  (pAmplifier<50? rand.nextInt(500-(pAmplifier*10)):0)
		{
		case 0:


			if (boss != null) {
				boss.moveTo(pLivingEntity.getX()+(rand.nextInt(8)-4), pLivingEntity.getY(), pLivingEntity.getZ()+(rand.nextInt(8)-4),0.0f, 0.0F);
				pLivingEntity.level().addFreshEntity(boss);
				break;


			}

		}

	}

	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}
	 **/
}