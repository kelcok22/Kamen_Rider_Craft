package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;


public class ModServerEvents {


	public static class ServerEvents {

		@SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {
			ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.FEET);
			if (event.getSlot() != EquipmentSlot.MAINHAND && event.getSlot() != EquipmentSlot.OFFHAND
			&& stack.getItem() instanceof RiderDriverItem belt && belt.isTransformed(event.getEntity())) belt.OnTransform(stack, event.getEntity());

			//event.getEntity().setInvisible(false);
		}
	}
}
