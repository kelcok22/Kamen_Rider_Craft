package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

import java.util.List;


public class RadarEffect extends InstantenousMobEffect {


	public RadarEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {

					List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15 + pAmplifier), entity ->
																	(entity instanceof Player && entity != player)
																	|| (entity instanceof Mob));
					for (LivingEntity enemy : nearbyEnemies) {
						enemy.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0,true,true));
					}
				}
			}
		}
		return true;
	}
}


