package com.kelco.kamenridercraft.effects.beneficial;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;


public class SlashEffect extends MobEffect {


    public SlashEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            if (livingEntity.getMainHandItem().getItem() instanceof SwordItem) {
                this.addAttributeModifiers(livingEntity.getAttributes(), amplifier);
            } else {
                this.removeAttributeModifiers(livingEntity.getAttributes());
            }
        }
        return true;
    }
}