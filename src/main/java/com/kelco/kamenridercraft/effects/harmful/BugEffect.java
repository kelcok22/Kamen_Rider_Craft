package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import com.kelco.kamenridercraft.util.MiscUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

import static com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems.WONDERSWAN;


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

            if (!(serverLevel.getDifficulty() == Difficulty.PEACEFUL)) {
                Random rand = new Random();
                if (player.getInventory().countItem(WONDERSWAN.get()) != 0) {
                    return true;
                }
                if (((amplifier < 50 ? (rand.nextInt(3000) - (amplifier + 1) * 5) : 0) <= 0)) {
                    Mob bugster;
                    if (livingEntity.hasEffect(EffectCore.HAZARD_LEVEL)) {
                        bugster = MobsCore.NEBULA_BUGSTERVIRUS.get().create(livingEntity.level());
                    } else {
                        bugster = MobsCore.BUGSTERVIRUS.get().create(livingEntity.level());
                    }
                    MiscUtil.spawnEnemy(livingEntity, bugster, 10);
                }
            }
        }
        return true;
    }
}