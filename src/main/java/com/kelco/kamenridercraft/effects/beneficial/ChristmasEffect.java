package com.kelco.kamenridercraft.effects.beneficial;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.extra_riders.ExtraRiderItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class ChristmasEffect extends MobEffect {


    public ChristmasEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int amplifier) {
        if (!pLivingEntity.level().isClientSide() && pLivingEntity instanceof Player player) {
            if (amplifier < 9) {
                player.addItem(new ItemStack(ExtraRiderItems.GIFT.get(), amplifier + 1));
            } else {
                player.addItem(new ItemStack(ExtraRiderItems.GIFT.get(), 8));
            }
            player.addEffect(new MobEffectInstance(EffectCore.CHRISTMAS, 5200, 9, false, false));
        }
        return true;
    }
}


