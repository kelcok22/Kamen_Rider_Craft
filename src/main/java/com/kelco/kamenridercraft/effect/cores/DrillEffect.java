package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;


public class DrillEffect extends InstantenousMobEffect {


	public DrillEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel) {
				if (pLivingEntity instanceof Player player) {
				if (player.isShiftKeyDown()){
					Vec3 look = pLivingEntity.getLookAngle();
					BlockPos pos = new BlockPos(pLivingEntity.getBlockX(), pLivingEntity.getBlockY() - 1, pLivingEntity.getBlockZ());

					if (pLivingEntity.level().getBlockState(pos) == Blocks.STONE.defaultBlockState()
							|| pLivingEntity.level().getBlockState(pos) == Blocks.NETHERRACK.defaultBlockState())
						pLivingEntity.level().destroyBlock(pos,true);
				}
				}
			}
		}
		return true;
	}
}


