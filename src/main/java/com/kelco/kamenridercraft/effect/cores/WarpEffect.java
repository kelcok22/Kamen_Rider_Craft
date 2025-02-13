package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.phys.Vec3;


public class WarpEffect extends InstantenousMobEffect {


	public WarpEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {

					if (player.isShiftKeyDown()&pAmplifier!=9){
						ThrownEnderpearl fireball = new ThrownEnderpearl(player.level(),player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						fireball.addDeltaMovement(player.getLookAngle().scale(3));
						player.level().addFreshEntity(fireball);
						player.addEffect(new MobEffectInstance(Effect_core.WARP, 120, 9,false,false));
					}


				}
			}
		}
		return true;
	}
}


