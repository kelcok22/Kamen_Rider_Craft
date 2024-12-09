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
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class CannonEffect extends InstantenousMobEffect {


	public CannonEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {

					if (player.isShiftKeyDown()&pAmplifier!=9){
						Vec3 vec3 = player.getLookAngle();
						SmallFireball smallfireball = new SmallFireball(player.level(), player, vec3.normalize());
						smallfireball.setPos(smallfireball.getX(), player.getY(0.5) + 0.5, smallfireball.getZ());
						player.level().addFreshEntity(smallfireball);
						player.addEffect(new MobEffectInstance(Effect_core.CANNON, 120/pAmplifier, 9,false,false));
					}


				}
			}
		}
		return true;
	}
}


