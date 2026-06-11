package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;


public class ResetEffect extends InstantenousMobEffect {


    public ResetEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide() && (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && !livingEntity.hasEffect(EffectCore.MUTEKI))) {
            RiderDriverItem.reset_Form_Item(livingEntity.getItemBySlot(EquipmentSlot.FEET));
        }
        return true;
    }
}