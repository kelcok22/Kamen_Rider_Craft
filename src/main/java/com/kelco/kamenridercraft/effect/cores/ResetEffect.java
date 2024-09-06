package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
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
            if (!pLivingEntity.hasEffect(Effect_core.MUTEKI)) {
				if (pLivingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {	
				RiderDriverItem.reset_Form_Item(pLivingEntity.getItemBySlot(EquipmentSlot.FEET));
			}
		}
		return true;
	}
}