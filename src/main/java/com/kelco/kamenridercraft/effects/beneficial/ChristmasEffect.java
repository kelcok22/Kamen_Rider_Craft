package com.kelco.kamenridercraft.effects.beneficial;


import com.kelco.kamenridercraft.item.extra_riders.ExtraRiderItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;


public class ChristmasEffect extends MobEffect {


    public ChristmasEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        Random rand = new Random();
        return  rand.nextInt(500 - (amplifier * 10)) == 0;
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int amplifier) {
        if (!pLivingEntity.level().isClientSide() && pLivingEntity instanceof Player player) {
            player.addItem(new ItemStack(ExtraRiderItems.GIFT.get(), 1));
        }
        return true;
    }
}