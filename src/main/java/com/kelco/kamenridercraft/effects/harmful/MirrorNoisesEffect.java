package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Objects;
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
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (Objects.requireNonNull(livingEntity.getEffect(EffectCore.MIRROR_NOISES)).getDuration() > 200) {
            livingEntity.level().playLocalSound(livingEntity, ModSounds.MIRROR_NOISES.get(), SoundSource.RECORDS, 1, new Random().nextInt(10));
        }
        if (livingEntity.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL && Objects.requireNonNull(livingEntity.getEffect(EffectCore.MIRROR_NOISES)).getDuration() < 2) {
            BaseHenchmenEntity boss = MobsCore.MIRROR_RIDER.get().create(livingEntity.level());
            if (boss != null) {
                BlockPos pos = livingEntity.blockPosition();
                RandomSource randomsource = serverLevel.getRandom();

                double d0 = (double) pos.getX() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;
                double d1 = pos.getY() + randomsource.nextInt(3) - 1;
                double d2 = (double) pos.getZ() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;

                int i = livingEntity.level().getChunkAt(pos).getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) d0, (int) d2);
                if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(d0, d1, d2))) {
                    boss.moveTo(d0, d1, d2);
                } else if (d1 > 0) {
                    boss.moveTo(d0, i, d2);
                } else {
                    boss.moveTo(d0, pos.getY(), d2);
                }
                boss.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(livingEntity.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
                livingEntity.level().addFreshEntity(boss);
            }
        }
        return true;
    }
}