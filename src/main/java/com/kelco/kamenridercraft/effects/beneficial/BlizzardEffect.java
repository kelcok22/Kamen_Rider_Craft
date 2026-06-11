package com.kelco.kamenridercraft.effects.beneficial;


import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;


public class BlizzardEffect extends InstantenousMobEffect {


    public BlizzardEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            BlockPos pos2 = new BlockPos(livingEntity.getBlockX() + 1, livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            BlockPos pos3 = new BlockPos(livingEntity.getBlockX() - 1, livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            BlockPos pos4 = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ() + 1);
            BlockPos pos5 = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ() - 1);

            if (livingEntity.level().getBlockState(pos) == Blocks.WATER.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos2) == Blocks.WATER.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos2, Blocks.ICE.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos3) == Blocks.WATER.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos3, Blocks.ICE.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos4) == Blocks.WATER.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos4, Blocks.ICE.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos5) == Blocks.WATER.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos5, Blocks.ICE.defaultBlockState());
            }
        }
        return true;
    }
}


