package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;


public class GreeedEffect extends MobEffect {


    public GreeedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Random rand = new Random();
        if (livingEntity.level() instanceof ServerLevel serverLevel) {
            BaseHenchmenEntity boss = MobsCore.YUMMY.get().create(livingEntity.level());
            if ((amplifier < 50 ? rand.nextInt(500 - (amplifier * 10)) : 0) == 0 && boss != null) {
                BlockPos pos = livingEntity.blockPosition();
                RandomSource randomsource = serverLevel.getRandom();

                double d0 = (double) pos.getX() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;
                double d1 = pos.getY() + randomsource.nextInt(3) - 1;
                double d2 = (double) pos.getZ() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;

                if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(d0, d1, d2))) {
                    if (d1 > 0) {
                        boss.moveTo(d0, d1, d2);
                    }
                    else {
                        livingEntity.moveTo(d0, pos.getY(), d2);
                    }
                    livingEntity.level().addFreshEntity(boss);
                }
            }
        }
        return true;
    }

}