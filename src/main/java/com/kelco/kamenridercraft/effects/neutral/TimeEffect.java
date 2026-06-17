package com.kelco.kamenridercraft.effects.neutral;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

public class TimeEffect extends InstantenousMobEffect {

    public TimeEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            ServerLifecycleHooks.getCurrentServer().getLevel(Level.OVERWORLD).setDayTime(livingEntity.level().dayTime() + 10);
        }
        return true;
    }
}