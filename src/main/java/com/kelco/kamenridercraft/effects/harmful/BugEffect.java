package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_SPAWN_AGGRESSION;
import static com.kelco.kamenridercraft.effects.EffectCore.FALL_CANCEL;
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
        if (livingEntity instanceof Player player && player.level() instanceof ServerLevel serverLevel
                && (!player.isCreative() && !player.isSpectator()) && serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
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

            BaseHenchmenEntity bugster = MobsCore.BUGSTERVIRUS.get().create(livingEntity.level());
            if (livingEntity.hasEffect(EffectCore.HAZARD_LEVEL)) {
                bugster = MobsCore.NEBULA_BUGSTERVIRUS.get().create(livingEntity.level());
            }

            Random rand = new Random();
            if (((amplifier < 50 ? rand.nextInt(500 - (amplifier * 10)) : 0))
                    - (livingEntity.getData(MOB_SPAWN_AGGRESSION) * 0.3) <= 0 && bugster != null) {
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
                    if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ))) {
                        bugster.setPos(randX, randY, randZ);
                    }
                    if (SpawnPlacements.isSpawnPositionOk(ZOMBIE, livingEntity.level(), potentialPosition)) {
                        bugster.setPos(randX, randY, randZ);
                        break;
                    }
                }
                livingEntity.level().addFreshEntity(bugster);
                if (!bugster.onGround()) {
                    bugster.addEffect(new MobEffectInstance(FALL_CANCEL, MobEffectInstance.INFINITE_DURATION,
                            255, true, false));
                }
                livingEntity.setData(MOB_SPAWN_AGGRESSION, 0);
            } else {
                livingEntity.setData(MOB_SPAWN_AGGRESSION, livingEntity.getData(MOB_SPAWN_AGGRESSION) + 1);
            }
        }
        return true;
    }
}