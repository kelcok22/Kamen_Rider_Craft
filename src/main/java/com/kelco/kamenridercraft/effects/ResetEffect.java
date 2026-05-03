package com.kelco.kamenridercraft.effects;

import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
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
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
            if (!pLivingEntity.hasEffect(EffectCore.MUTEKI)) {
				if (pLivingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {	
				RiderDriverItem.reset_Form_Item(pLivingEntity.getItemBySlot(EquipmentSlot.FEET));
			}
		}
		return true;
	}
}