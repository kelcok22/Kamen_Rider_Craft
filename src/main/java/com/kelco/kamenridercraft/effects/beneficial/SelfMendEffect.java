package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;


public class SelfMendEffect extends MobEffect {


    public SelfMendEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Random rand = new Random();
        if (!livingEntity.level().isClientSide() && (amplifier < 50 ? rand.nextInt(500 - (amplifier * 10)) : 0) == 0) {
            livingEntity.getItemBySlot(EquipmentSlot.HEAD).setDamageValue(livingEntity.getItemBySlot(EquipmentSlot.HEAD).getDamageValue() - 1);
            livingEntity.getItemBySlot(EquipmentSlot.CHEST).setDamageValue(livingEntity.getItemBySlot(EquipmentSlot.CHEST).getDamageValue() - 1);
            livingEntity.getItemBySlot(EquipmentSlot.LEGS).setDamageValue(livingEntity.getItemBySlot(EquipmentSlot.LEGS).getDamageValue() - 1);
            livingEntity.getItemBySlot(EquipmentSlot.FEET).setDamageValue(livingEntity.getItemBySlot(EquipmentSlot.FEET).getDamageValue() - 1);
            livingEntity.getItemBySlot(EquipmentSlot.MAINHAND).setDamageValue(livingEntity.getItemBySlot(EquipmentSlot.MAINHAND).getDamageValue() - 1);
            livingEntity.getItemBySlot(EquipmentSlot.OFFHAND).setDamageValue(livingEntity.getItemBySlot(EquipmentSlot.OFFHAND).getDamageValue() - 1);
        }
        return true;
    }
}