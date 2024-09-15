package com.kelco.kamenridercraft.effect.cores;

import java.util.List;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;


public class SmellEffect extends InstantenousMobEffect {


	public SmellEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {
					List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10), entity ->
																	(entity instanceof Player && entity != player)
																	|| (entity instanceof Mob mob && mob.getTarget() == pLivingEntity));
					for (LivingEntity enemy : nearbyEnemies) {
						enemy.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0,true,true));
						enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1,true,true));
					}
				}
			}
		}
		return true;
	}
}


