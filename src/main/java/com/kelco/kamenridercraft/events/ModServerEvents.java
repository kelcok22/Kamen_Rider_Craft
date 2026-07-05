package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;


public class ModServerEvents {


	public static class ServerEvents {


        @SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {

			ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.FEET);
			if (event.getSlot().isArmor() && stack.getItem() instanceof RiderDriverItem belt && belt.isTransformed(event.getEntity()) && !stack.has(DataComponents.CUSTOM_DATA)) {
				RiderDriverItem.setUpdateForm(event.getEntity().getItemBySlot(EquipmentSlot.FEET),event.getEntity());
			}

		}
	}
}
