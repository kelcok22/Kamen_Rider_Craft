package com.kelco.kamenridercraft.effects.neutral;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.effects.UncurableEffect;
import com.kelco.kamenridercraft.util.DimensionUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;

import java.util.Optional;


public class DreamingEffect extends UncurableEffect {
    public DreamingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Level level = livingEntity.level();
        if (!level.isClientSide && livingEntity.getEffect(EffectCore.DREAMING).getDuration() < 2) {
            if (livingEntity instanceof ServerPlayer serverPlayer && !livingEntity.level().isClientSide()) DimensionUtil.returnToSpawn(livingEntity.getServer().overworld(), serverPlayer);
        }
        return true;
    }


}


