package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Random;


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
