package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class GhostEffect extends MobEffect {


    public GhostEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            livingEntity.fallDistance = 0.0f;
            if (livingEntity instanceof Player player) {
                player.getFoodData().setFoodLevel(20);
                if (player.isShiftKeyDown()) {
                    player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, amplifier, false, false));
                }
            }
        }
        return true;
    }
}