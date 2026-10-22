package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.effects.EffectCore.SAFE_LANDING;
import static com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems.WONDERSWAN;
import static net.minecraft.world.entity.EntityType.ZOMBIE;


public class BugEffect extends MobEffect {
    public BugEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer player && player.level() instanceof ServerLevel serverLevel) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ZeroOneRiderItems.ZAIA_THOUSANDRIVER.get()) {
                if (player.getInventory().countItem(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()) > 0) {
                    if (player.getInventory().getItem(40).getItem() == ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()) {
                        player.getInventory().removeItem(40, 1);
                    } else {
                        player.getInventory().removeItem(new ItemStack(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()));
                        player.getInventory().removeItem(player.getInventory()
                                .findSlotMatchingItem(new ItemStack(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get())), 1);
                    }
                    player.removeEffect(EffectCore.BUGSTER);
                    player.drop(new ItemStack(ZeroOneRiderItems.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get()), false);
                }
            }


            Random rand = new Random();
            boolean gamerule = serverLevel.getGameRules().getBoolean(ModGameRules.RULE_SPAWN_EFFECT_MOBS_IN_CREATIVE);

            if ((!player.isSpectator()) && serverLevel.getDifficulty() != Difficulty.PEACEFUL && (gamerule || !player.isCreative())) {
                if (player.getInventory().countItem(WONDERSWAN.get()) != 0) {
                    return true;
                }
                if (((amplifier < 50 ? (rand.nextInt(3000) - (amplifier + 1) * 5) : 0) <= 0)) {
                    List<Mob> nearbyEnemies = serverLevel.getEntitiesOfClass(Mob.class, player.getBoundingBox().inflate(10), Objects::nonNull);
                    if (nearbyEnemies.size() > 10){
                        return true;
                    }

                    Mob bugster;
                    if (livingEntity.hasEffect(EffectCore.HAZARD_LEVEL)) {
                        bugster = MobsCore.NEBULA_BUGSTERVIRUS.get().create(livingEntity.level());
                    } else {
                        bugster = MobsCore.BUGSTERVIRUS.get().create(livingEntity.level());
                    }

                    int tempRandX = (livingEntity.getBlockX()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    int tempRandZ = (livingEntity.getBlockZ()
                            + (rand.nextInt(3, 10))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    bugster.setPos(tempRandX, livingEntity.getY(), tempRandZ);

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
                            bugster.setPos(randX, randY, randZ);
                            break;
                        }
                    }
                    livingEntity.level().addFreshEntity(bugster);
                    if (!bugster.onGround()) {
                        bugster.addEffect(new MobEffectInstance(SAFE_LANDING, MobEffectInstance.INFINITE_DURATION,
                                255, true, false));
                    }
                }
            }
        }
        return true;
    }
}