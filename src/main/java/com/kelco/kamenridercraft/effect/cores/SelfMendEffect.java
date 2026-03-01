package com.kelco.kamenridercraft.effect.cores;

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
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		Random rand = new Random();
		if ((pAmplifier < 50 ? rand.nextInt(500 - (pAmplifier * 10)) : 0) == 0) {
			pLivingEntity.getItemBySlot(EquipmentSlot.HEAD).setDamageValue(pLivingEntity.getItemBySlot(EquipmentSlot.HEAD).getDamageValue() - 1);
			pLivingEntity.getItemBySlot(EquipmentSlot.CHEST).setDamageValue(pLivingEntity.getItemBySlot(EquipmentSlot.CHEST).getDamageValue() - 1);
			pLivingEntity.getItemBySlot(EquipmentSlot.LEGS).setDamageValue(pLivingEntity.getItemBySlot(EquipmentSlot.LEGS).getDamageValue() - 1);
			pLivingEntity.getItemBySlot(EquipmentSlot.FEET).setDamageValue(pLivingEntity.getItemBySlot(EquipmentSlot.FEET).getDamageValue() - 1);
			pLivingEntity.getItemBySlot(EquipmentSlot.MAINHAND).setDamageValue(pLivingEntity.getItemBySlot(EquipmentSlot.MAINHAND).getDamageValue() -1);
			pLivingEntity.getItemBySlot(EquipmentSlot.OFFHAND).setDamageValue(pLivingEntity.getItemBySlot(EquipmentSlot.OFFHAND).getDamageValue() - 1);
			}
		return true;
	}
}