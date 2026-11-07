package com.kelco.kamenridercraft.effects.beneficial;


import com.kelco.kamenridercraft.util.DimensionUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class ReturnEffect extends InstantenousMobEffect {


    public ReturnEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer && !livingEntity.level().isClientSide())
            DimensionUtil.returnToSpawn(livingEntity.getServer().overworld(), serverPlayer);
        return false;
    }
}


