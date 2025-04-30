package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Random;


public class HeavyAccelerationEffect extends InstantenousMobEffect {


	public HeavyAccelerationEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {


					List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, pLivingEntity.getBoundingBox().inflate(15), entity ->
																	(entity instanceof Player && entity != pLivingEntity)
																	|| (entity instanceof Mob));
					for (LivingEntity enemy : nearbyEnemies) {

						Random generator = new Random();
						int rand = generator.nextInt(10);
					if (rand==1){
							enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 8, true, true));
							enemy.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 8, true, true));
							enemy.addEffect(new MobEffectInstance(Effect_core.LOW_GRAVITY, 3, 8, true, true));
						}
					}
			}
		}
		return true;
	}
}


