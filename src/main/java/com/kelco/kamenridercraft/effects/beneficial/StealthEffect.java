package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class StealthEffect extends InstantenousMobEffect {


    public StealthEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide() && livingEntity instanceof Player player) {
            if (player.isCrouching())
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false));
        }
        return true;
    }
}