package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;


public class ModServerEvents {


	public static class ServerEvents {

		@SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.FEET);
				if (stack.getItem() instanceof RiderDriverItem) {
					CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
					if (!tag.getBoolean("isTransformed")) {
						if (event.getSlot() != EquipmentSlot.MAINHAND && event.getSlot() != EquipmentSlot.OFFHAND
								&& stack.getItem() instanceof RiderDriverItem belt && belt.isTransformed(event.getEntity()))
							belt.OnTransform(stack, event.getEntity(), tag);
					}
				}
			}
		}
	}
}
