package com.kelco.kamenridercraft.effects;

import com.kelco.kamenridercraft.item.base_items.BaseCityItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

import java.awt.*;

public class NightEffect extends InstantenousMobEffect {

    public NightEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            ServerLifecycleHooks.getCurrentServer().getLevel(Level.OVERWORLD).setDayTime(18000);
        }
        return false;
    }
}