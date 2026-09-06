package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.USED_ABILITY;


public class ModServerEvents {


	public static class ServerEvents {


        @SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {

			ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.FEET);
			if (event.getSlot().isArmor() && stack.getItem() instanceof RiderDriverItem belt && belt.isTransformed(event.getEntity()) && !stack.has(DataComponents.CUSTOM_DATA)) {
				RiderDriverItem.setUpdateForm(event.getEntity().getItemBySlot(EquipmentSlot.FEET));
			}

		}

        @SubscribeEvent
        public void addLivingDamageEvent(LivingDamageEvent.Post event) {
            if (event.getEntity() instanceof ServerPlayer player && player.getInventory().countItem(ZeztzRiderItems.VOID_CAPSEM.get()) >=1 && event.getSource().is(DamageTypes.LIGHTNING_BOLT)) {
                if (player.getOffhandItem().is(ZeztzRiderItems.VOID_CAPSEM.get())) {
                    player.getOffhandItem().shrink(1);
                } else {
                    player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(ZeztzRiderItems.VOID_CAPSEM.get())), 1);
                }player.getInventory().add(new ItemStack(ZeztzRiderItems.PLASMA_CAPSEM.get()));
            }
        }
	}
}
