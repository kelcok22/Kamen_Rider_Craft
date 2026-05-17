package com.kelco.kamenridercraft.effects;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
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
        if ((pAmplifier < 50 ? rand.nextInt(500 - (pAmplifier * 10)) : 0) == 0) {
            if (boss != null) {

                int X= (int) (pLivingEntity.getX() + (rand.nextInt(8) - 4));
                int Y= (int) pLivingEntity.getY();
                int Z= (int) (pLivingEntity.getZ() + (rand.nextInt(8) - 4));
                BlockPos pos = new BlockPos(X,Y,Z);
                int i = pLivingEntity.level().getChunkAt(pos).getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos .getX(), pos.getZ()) + 1;
                if(i>0)boss.moveTo(X,i,Z);
                else boss.moveTo(X,Y,Z);
                pLivingEntity.level().addFreshEntity(boss);
            }
        }
		return true;
	}

}