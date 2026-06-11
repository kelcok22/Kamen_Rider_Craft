package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;

public class DrillEffect extends InstantenousMobEffect {


    public DrillEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel && livingEntity.isShiftKeyDown()) {
            BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
            if (livingEntity.level().getBlockState(pos) == Blocks.STONE.defaultBlockState()
                    || livingEntity.level().getBlockState(pos) == Blocks.NETHERRACK.defaultBlockState())
                livingEntity.level().destroyBlock(pos, true);
        }
        return true;
    }
}