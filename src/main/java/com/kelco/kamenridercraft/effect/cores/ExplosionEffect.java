package com.kelco.kamenridercraft.effect.cores;


import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;


public class ExplosionEffect extends InstantenousMobEffect {


	public ExplosionEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel) {

				Vec3 look = pLivingEntity.getLookAngle();
				boolean flag = pLivingEntity.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
				pLivingEntity.level().explode(null, pLivingEntity.getX()+ look.x * 8, pLivingEntity.getY() +1,pLivingEntity.getZ() + look.z * 8, pAmplifier, flag, Level.ExplosionInteraction.MOB);

			}
		}
		return false;
	}
}


