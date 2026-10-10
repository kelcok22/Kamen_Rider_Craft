package com.kelco.kamenridercraft.effects.harmful;

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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Random;

import static com.kelco.kamenridercraft.effects.EffectCore.FALL_CANCEL;
import static com.kelco.kamenridercraft.effects.EffectCore.MIRROR_NOISES;
import static net.minecraft.world.entity.EntityType.ZOMBIE;


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
        Random rand = new Random();

        if (livingEntity.getEffect(MIRROR_NOISES).getDuration() > 200) {
            livingEntity.level().playLocalSound(livingEntity, ModSounds.MIRROR_NOISES.get(), SoundSource.RECORDS, 1, new Random().nextInt(10));
        }
        if (livingEntity.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && livingEntity.getEffect(MIRROR_NOISES).getDuration() < 2) {
            BaseHenchmenEntity boss = MobsCore.MIRROR_RIDER.get().create(livingEntity.level());
            if (boss != null) {
                livingEntity.level().addFreshEntity(boss);
                int tempRandX = (livingEntity.getBlockX()
                        + (rand.nextInt(3, 10))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                int tempRandZ = (livingEntity.getBlockZ()
                        + (rand.nextInt(3, 10))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                boss.setPos(tempRandX, livingEntity.getY(), tempRandZ);

                for (int i = 0; i < 400; ++i) {
                    int randX = (livingEntity.getBlockX()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    int randY = (livingEntity.getBlockY()
                            + rand.nextInt(-10, 10));

                    int randZ = (livingEntity.getBlockZ()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    BlockPos potentialPosition = new BlockPos(randX, randY, randZ);
                    if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ))) {
                        boss.setPos(randX, randY, randZ);
                    }
                    if (SpawnPlacements.isSpawnPositionOk(ZOMBIE, livingEntity.level(), potentialPosition)) {
                        boss.setPos(randX, randY, randZ);
                        break;
                    }
                }
                boss.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(livingEntity.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
                livingEntity.level().addFreshEntity(boss);
                if (!boss.onGround()) {
                    boss.addEffect(new MobEffectInstance(FALL_CANCEL, MobEffectInstance.INFINITE_DURATION,
                            255, true, false));
                }
            }
        }
        return true;
    }
}