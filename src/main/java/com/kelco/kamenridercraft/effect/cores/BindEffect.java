package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;


public class BindEffect extends InstantenousMobEffect {


	public BindEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel) {

				Vec3 look = pLivingEntity.getLookAngle();
				BlockPos pos = new BlockPos((int) (pLivingEntity.getX()+ look.x * 5), (int) (pLivingEntity.getY() +1), (int) (pLivingEntity.getZ() + look.z * 5));
				BlockPos pos2 = new BlockPos((int) (pLivingEntity.getX()+ look.x * 5), (int) (pLivingEntity.getY() ), (int) (pLivingEntity.getZ() + look.z * 5));

				if (pLivingEntity.level().isEmptyBlock(pos))pLivingEntity.level().setBlockAndUpdate(pos, Blocks.COBWEB.defaultBlockState());
				if (pLivingEntity.level().isEmptyBlock(pos2))pLivingEntity.level().setBlockAndUpdate(pos2, Blocks.COBWEB.defaultBlockState());

			}
		}
		return false;
	}
}


