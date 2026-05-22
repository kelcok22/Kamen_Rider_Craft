package com.kelco.kamenridercraft.effects;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.levelgen.Heightmap;

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
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		BaseHenchmenEntity boss  =   MobsCore.YUMMY.get().create(pLivingEntity.level());
		Random rand = new Random();
        if (pLivingEntity.level() instanceof ServerLevelAccessor slevel) {
        if ((pAmplifier < 50 ? rand.nextInt(500 - (pAmplifier * 10)) : 0) == 0) {
            if (boss != null) {
                BlockPos pos = pLivingEntity.blockPosition();
                RandomSource randomsource = slevel.getRandom();
                double d0 = (double) pos.getX() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;
                double d1 = pos.getY() + randomsource.nextInt(3) - 1;
                double d2 = (double) pos.getZ() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;

                if (slevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(d0, d1, d2))) {

                    int Y2 = pLivingEntity.level().getChunkAt(pos).getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos.getX(), pos.getZ()) + 1;
                    if (d1 > 0) boss.moveTo(d0, d1, d2);
                    else boss.moveTo(d0, pos.getY(), d2);
                    pLivingEntity.level().addFreshEntity(boss);
                }
            }
        }
        }
		return true;
	}

}