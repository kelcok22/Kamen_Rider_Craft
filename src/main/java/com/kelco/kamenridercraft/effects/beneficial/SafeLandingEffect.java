package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import static com.kelco.kamenridercraft.effects.EffectCore.SAFE_LANDING;


public class SafeLandingEffect extends MobEffect {
    public SafeLandingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        livingEntity.fallDistance = 0.0f;

        if (livingEntity.onGround()
                || livingEntity instanceof Player player && (player.isSpectator() || player.isCreative())) {
            livingEntity.removeEffect(SAFE_LANDING);
        }
        return true;
    }
}