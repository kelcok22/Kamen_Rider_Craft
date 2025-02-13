package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;


public class GatlingEffect extends InstantenousMobEffect {


	public GatlingEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {

					if (player.isShiftKeyDown()&pAmplifier!=9){
						Arrow fireball = new Arrow(player.level(),player, new ItemStack(Blocks.AIR), null);
						fireball.setPos(fireball.getX(), player.getY(0.5) + 0.5, fireball.getZ());
						fireball.addDeltaMovement(player.getLookAngle().scale(3));
						player.level().addFreshEntity(fireball);

					}


				}
			}
		}
		return true;
	}
}


