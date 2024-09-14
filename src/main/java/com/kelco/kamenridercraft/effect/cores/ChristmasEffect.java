package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;


public class ChristmasEffect extends InstantenousMobEffect {


	public ChristmasEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel) {
				if (pLivingEntity instanceof Player player) {
					if (player.isShiftKeyDown()){
						Vec3 vec3 = player.getLookAngle();
						Snowball snowball = new Snowball(player.level(),player);
						snowball.setPos(snowball.getX(), player.getY(0.5D) + 0.5D, snowball.getZ());
						snowball.setDeltaMovement( snowball.getDeltaMovement().add(vec3.x*3, vec3.y*3, vec3.z*3));
						player.level().addFreshEntity(snowball);
					}
				}
			}
		}
		return true;
	}
}


