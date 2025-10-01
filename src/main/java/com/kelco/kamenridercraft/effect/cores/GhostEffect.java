package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class GhostEffect extends MobEffect {


	public GhostEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		if(pLivingEntity instanceof Player player) {
            player.getFoodData().setFoodLevel(20);
            pLivingEntity.fallDistance = 0.0f;

            ItemStack stack = pLivingEntity.getItemBySlot(EquipmentSlot.FEET);
            if (!pLivingEntity.level().isClientSide()) {
                if (pLivingEntity.isShiftKeyDown()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, pAmplifier, false, false));
            }
        }
		}
		return true;
	}
}