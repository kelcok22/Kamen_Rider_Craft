package com.kelco.kamenridercraft.effects.harmful;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;


public class FallEffect extends InstantenousMobEffect {


    public FallEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel) {
            BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            BlockPos pos2 = new BlockPos(livingEntity.getBlockX() + 1, livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            BlockPos pos3 = new BlockPos(livingEntity.getBlockX() - 1, livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            BlockPos pos4 = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ() + 1);
            BlockPos pos5 = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ() - 1);

            if (livingEntity.level().getBlockState(pos) != Blocks.BEDROCK.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos) != Blocks.BEDROCK.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos2, Blocks.AIR.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos) != Blocks.BEDROCK.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos3, Blocks.AIR.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos) != Blocks.BEDROCK.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos4, Blocks.AIR.defaultBlockState());
            }
            if (livingEntity.level().getBlockState(pos) != Blocks.BEDROCK.defaultBlockState()) {
                livingEntity.level().setBlockAndUpdate(pos5, Blocks.AIR.defaultBlockState());
            }
        }
        return true;
    }
}