package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class ThunderEffect extends InstantenousMobEffect {

	public ThunderEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
		     if (pLivingEntity.level() instanceof ServerLevel ) {

				 Vec3 look = pLivingEntity.getLookAngle();
				 LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,pLivingEntity.level());
				 thunder.setPos( pLivingEntity.getX()+ look.x * 8,  -1 + pLivingEntity.getY() + look.y * 5,  pLivingEntity.getZ() + look.z * 8);
				 pLivingEntity.level().addFreshEntity(thunder);
		      }
		}
		return false;
	}
}