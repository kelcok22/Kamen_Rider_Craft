package com.kelco.kamenridercraft.effects.neutral;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.effects.UncurableEffect;
import com.kelco.kamenridercraft.util.DimensionUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;


public class DreamingEffect extends UncurableEffect {
    public DreamingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer && livingEntity.getEffect(EffectCore.DREAMING).getDuration() < 2) {
            if (!serverPlayer.isCreative()) {
                serverPlayer.addEffect(new MobEffectInstance(EffectCore.INSOMNIA, 1200, 0, false, true));
            }
            DimensionUtil.returnToSpawn(livingEntity.getServer().overworld(), serverPlayer);
        }
        return true;
    }
}