package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.YummyEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_SPAWN_AGGRESSION;
import static com.kelco.kamenridercraft.effects.EffectCore.*;
import static net.minecraft.world.entity.EntityType.ZOMBIE;


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
        if (livingEntity instanceof Player player && (!player.isCreative() && !player.isSpectator())) {
            if (livingEntity.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
                YummyEntity yummy = MobsCore.YUMMY.get().create(livingEntity.level());
                if (((amplifier < 50 ? rand.nextInt(500 - (amplifier * 10)) : 0))
                        - (livingEntity.getData(MOB_SPAWN_AGGRESSION) * 0.3) <= 0 && yummy != null) {
                    int tempRandX = (livingEntity.getBlockX()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    int tempRandZ = (livingEntity.getBlockZ()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    yummy.setPos(tempRandX, livingEntity.getY(), tempRandZ);

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
                            yummy.setPos(randX, randY, randZ);
                        }
                        if (SpawnPlacements.isSpawnPositionOk(ZOMBIE, livingEntity.level(), potentialPosition)) {
                            yummy.setPos(randX, randY, randZ);
                            break;
                        }
                    }
                    livingEntity.level().addFreshEntity(yummy);
                    if (!yummy.onGround()) {
                        yummy.addEffect(new MobEffectInstance(FALL_CANCEL, MobEffectInstance.INFINITE_DURATION,
                                255, true, false));
                    }
                    livingEntity.setData(MOB_SPAWN_AGGRESSION, 0);
                } else {
                    livingEntity.setData(MOB_SPAWN_AGGRESSION, livingEntity.getData(MOB_SPAWN_AGGRESSION) + 1);
                }
            }
        }
        return true;
    }
}