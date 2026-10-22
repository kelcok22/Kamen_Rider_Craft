package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.UndeadEntity;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.effects.EffectCore.SAFE_LANDING;
import static net.minecraft.world.entity.EntityType.ZOMBIE;


public class UnsealedEffect extends MobEffect {
    public UnsealedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Random rand = new Random();
        boolean gamerule = livingEntity.level().getGameRules().getBoolean(ModGameRules.RULE_SPAWN_EFFECT_MOBS_IN_CREATIVE);

        if (livingEntity instanceof Player player && ((gamerule || !player.isCreative()) && !player.isSpectator())) {
            if (livingEntity.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
                if (((amplifier < 50 ? (rand.nextInt(3000) - (amplifier + 1) * 5) : 0) <= 0)) {
                    List<Mob> nearbyEnemies = serverLevel.getEntitiesOfClass(Mob.class, player.getBoundingBox().inflate(10), Objects::nonNull);
                    if (nearbyEnemies.size() > 10){
                        return true;
                    }

                    UndeadEntity undead = MobsCore.UNDEAD.get().create(livingEntity.level());

                    if (rand.nextInt(500) == 0) {
                        undead = MobsCore.ACE_UNDEAD.get().create(livingEntity.level());
                    }

                    int tempRandX = (livingEntity.getBlockX()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    int tempRandZ = (livingEntity.getBlockZ()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    undead.setPos(tempRandX, livingEntity.getY(), tempRandZ);

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
                        if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ)) &&
                                SpawnPlacements.isSpawnPositionOk(ZOMBIE, livingEntity.level(), potentialPosition)) {
                            undead.setPos(randX, randY, randZ);
                            break;
                        }
                    }
                    livingEntity.level().addFreshEntity(undead);
                    if (!undead.onGround()) {
                        undead.addEffect(new MobEffectInstance(SAFE_LANDING, MobEffectInstance.INFINITE_DURATION,
                                255, true, false));
                    }
                }
            }
        }
        return true;
    }
}