package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;


public class ModServerEvents {


	public static class ServerEvents {

		@SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {

			ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.FEET);
			if (event.getSlot().isArmor() && stack.getItem() instanceof RiderDriverItem belt && belt.isTransformed(event.getEntity()) && !stack.has(DataComponents.CUSTOM_DATA)) {
				RiderDriverItem.set_Upadete_Form(event.getEntity().getItemBySlot(EquipmentSlot.FEET));
			}

		}
	}
}
