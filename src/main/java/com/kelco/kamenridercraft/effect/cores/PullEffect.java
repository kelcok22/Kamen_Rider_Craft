package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class PullEffect extends InstantenousMobEffect {


	public PullEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {
					List<ItemEntity> nearbyItem= level.getEntitiesOfClass(ItemEntity.class, player.getBoundingBox().inflate(10), entity ->
																	(entity instanceof ItemEntity item));
					for (ItemEntity enemy : nearbyItem) {

						double X =pLivingEntity.getX()-enemy.getX();
						double Y =pLivingEntity.getY()-enemy.getY();
						double Z =pLivingEntity.getZ()-enemy.getZ();

						Vec3 look = new Vec3(X,Y,Z);
						enemy.setDeltaMovement(pLivingEntity.getDeltaMovement().add(look.x*(0.1*(1+pAmplifier)), look.y*(0.1*(1+pAmplifier))+pLivingEntity.getGravity(), look.z*(0.1*(1+pAmplifier))));


					}
				}
			}
		}
		return true;
	}
}


