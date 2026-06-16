package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;


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
        if (livingEntity instanceof Player player && player.level() instanceof ServerLevel serverLevel) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ZeroOneRiderItems.ZAIA_THOUSANDRIVER.get()) {
                if (player.getInventory().countItem(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()) > 0) {
                    if (player.getInventory().getItem(40).getItem() == ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()) {
                        player.getInventory().removeItem(40, 1);
                    } else {
                        player.getInventory().removeItem(new ItemStack(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()));
                        player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get())), 1);
                    }
                    player.removeEffect(EffectCore.BUGSTER);
                    player.drop(new ItemStack(ZeroOneRiderItems.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get()), false);
                }
            }

            BaseHenchmenEntity boss = MobsCore.BUGSTERVIRUS.get().create(livingEntity.level());
            if (livingEntity.hasEffect(EffectCore.HAZARD_LEVEL)) {
                boss = MobsCore.NEBULA_BUGSTERVIRUS.get().create(livingEntity.level());
            }

            Random rand = new Random();
            if ((amplifier < 50 ? rand.nextInt(500 - (amplifier * 10)) : 0) == 0 && boss != null) {
                BlockPos pos = livingEntity.blockPosition();
                RandomSource randomsource = serverLevel.getRandom();

                double d0 = (double) pos.getX() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;
                double d1 = pos.getY() + randomsource.nextInt(3) - 1;
                double d2 = (double) pos.getZ() + (randomsource.nextDouble() - randomsource.nextDouble()) * 8 + (double) 0.5F;

                if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(d0, d1, d2))) {
                    if (d1 > 0) boss.moveTo(d0, d1, d2);
                    else boss.moveTo(d0, pos.getY(), d2);
                    livingEntity.level().addFreshEntity(boss);
                }
            }
        }
        return true;
    }

}