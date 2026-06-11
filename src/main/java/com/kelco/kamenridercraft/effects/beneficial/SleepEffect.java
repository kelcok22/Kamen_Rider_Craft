package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

public class SleepEffect extends InstantenousMobEffect {

    public SleepEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
		if (!livingEntity.level().isClientSide()) {
			ServerLifecycleHooks.getCurrentServer().getLevel(Level.OVERWORLD).setDayTime(0);
		}
        return false;
    }
}