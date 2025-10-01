package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class PushEffect extends InstantenousMobEffect {


	public PushEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {
					List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(2+(pAmplifier*2)), entity ->
							(entity instanceof Mob mob));
					for (LivingEntity enemy : nearbyEnemies) {

						double X =  enemy.getX()-pLivingEntity.getX();
						double Y =  enemy.getY()-pLivingEntity.getY();
						double Z =  enemy.getZ()-pLivingEntity.getZ();

						Vec3 look = new Vec3(X, Y, Z);
						enemy.setDeltaMovement(pLivingEntity.getDeltaMovement().add(look.x * (0.1 * (1 + pAmplifier)), look.y * (0.1 * (1 + pAmplifier)) + pLivingEntity.getGravity(), look.z * (0.1 * (1 + pAmplifier))));


					}
				}
			}
		}
		return true;
	}
}