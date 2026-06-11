package com.kelco.kamenridercraft.effects.harmful;


import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;

import java.util.Optional;


public class ExplodeEffect extends MobEffect {
    public ExplodeEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Level level = livingEntity.level();
        if (!level.isClientSide && livingEntity.getEffect(EffectCore.EXPLODE).getDuration() < 2) {
            ExplosionDamageCalculator damageCalc = new SimpleExplosionDamageCalculator(false, true, Optional.of(1.5F), Optional.empty());
            if (amplifier < 255)
                level.explode(null, level.damageSources().explosion(null, livingEntity), damageCalc, livingEntity.getX(), livingEntity.getY() + 2, livingEntity.getZ(), amplifier, false, Level.ExplosionInteraction.MOB);
            else
                level.explode(null, livingEntity.getX(), livingEntity.getY() + 2, livingEntity.getZ(), amplifier, true, Level.ExplosionInteraction.MOB);
        }
        return true;
    }


}


