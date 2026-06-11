package com.kelco.kamenridercraft.effects.harmful;


import net.minecraft.core.BlockPos;
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
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            Vec3 look = livingEntity.getLookAngle();
            BlockPos pos = new BlockPos((int) (livingEntity.getX() + look.x * 5), (int) (livingEntity.getY() + 1), (int) (livingEntity.getZ() + look.z * 5));
            BlockPos pos2 = new BlockPos((int) (livingEntity.getX() + look.x * 5), (int) (livingEntity.getY()), (int) (livingEntity.getZ() + look.z * 5));

            if (livingEntity.level().isEmptyBlock(pos))
                livingEntity.level().setBlockAndUpdate(pos, Blocks.COBWEB.defaultBlockState());
            if (livingEntity.level().isEmptyBlock(pos2))
                livingEntity.level().setBlockAndUpdate(pos2, Blocks.COBWEB.defaultBlockState());
        }
        return false;
    }
}


