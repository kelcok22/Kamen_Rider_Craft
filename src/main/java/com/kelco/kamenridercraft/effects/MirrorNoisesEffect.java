package com.kelco.kamenridercraft.effects;

import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Random;


public class MirrorNoisesEffect extends MobEffect {


	public MirrorNoisesEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        BaseHenchmenEntity boss  =   MobsCore.MIRROR_RIDER.get().create(pLivingEntity.level());
        Random rand = new Random();
        int rand2 = rand.nextInt(10);
        if (pLivingEntity.getEffect(EffectCore.MIRROR_NOISES).getDuration() > 200) {
            pLivingEntity.level().playLocalSound(pLivingEntity, ModSounds.MIRROR_NOISES.get(), SoundSource.RECORDS, 1, rand2);
        }
        if (pLivingEntity.level() instanceof ServerLevelAccessor slevel && pLivingEntity.getEffect(EffectCore.MIRROR_NOISES).getDuration() < 2) {
            if (boss != null) {
                int X= (int) (pLivingEntity.getX() + (rand.nextInt(8) - 4));
                int Y= (int) pLivingEntity.getY();
                int Z= (int) (pLivingEntity.getZ() + (rand.nextInt(8) - 4));
                BlockPos pos = new BlockPos(X,Y,Z);
                int i = pLivingEntity.level().getChunkAt(pos).getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos .getX(), pos.getZ());
                if(i>0)boss.moveTo(X,i,Z);
                else boss.moveTo(X,Y,Z);
                boss.finalizeSpawn(slevel, slevel.getCurrentDifficultyAt(pLivingEntity.blockPosition()), MobSpawnType.MOB_SUMMONED,null);
                pLivingEntity.level().addFreshEntity(boss);
            }
        }
		return true;
	}

}