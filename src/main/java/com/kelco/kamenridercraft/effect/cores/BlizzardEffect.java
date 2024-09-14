package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;


public class BlizzardEffect extends InstantenousMobEffect {


	public BlizzardEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel) {

				Vec3 look = pLivingEntity.getLookAngle();
				BlockPos pos = new BlockPos(pLivingEntity.getBlockX(), pLivingEntity.getBlockY() -1, pLivingEntity.getBlockZ());
				BlockPos pos2 = new BlockPos(pLivingEntity.getBlockX()+1, pLivingEntity.getBlockY() -1, pLivingEntity.getBlockZ());
				BlockPos pos3 = new BlockPos(pLivingEntity.getBlockX()-1, pLivingEntity.getBlockY() -1, pLivingEntity.getBlockZ());
				BlockPos pos4 = new BlockPos(pLivingEntity.getBlockX(), pLivingEntity.getBlockY() -1, pLivingEntity.getBlockZ()+1);
				BlockPos pos5 = new BlockPos(pLivingEntity.getBlockX(), pLivingEntity.getBlockY() -1, pLivingEntity.getBlockZ()-1);

				if (pLivingEntity.level().getBlockState(pos)==Blocks.WATER.defaultBlockState())pLivingEntity.level().setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
				if (pLivingEntity.level().getBlockState(pos2)==Blocks.WATER.defaultBlockState())pLivingEntity.level().setBlockAndUpdate(pos2, Blocks.ICE.defaultBlockState());
				if (pLivingEntity.level().getBlockState(pos3)==Blocks.WATER.defaultBlockState())pLivingEntity.level().setBlockAndUpdate(pos3, Blocks.ICE.defaultBlockState());
				if (pLivingEntity.level().getBlockState(pos4)==Blocks.WATER.defaultBlockState())pLivingEntity.level().setBlockAndUpdate(pos4, Blocks.ICE.defaultBlockState());
				if (pLivingEntity.level().getBlockState(pos5)==Blocks.WATER.defaultBlockState())pLivingEntity.level().setBlockAndUpdate(pos5, Blocks.ICE.defaultBlockState());


			}
		}
		return true;
	}
}


