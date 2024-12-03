package com.kelco.kamenridercraft.item.build;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Build_Rider_Items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class NebulasteamGunItem extends BaseBlasterItem {
	
	public NebulasteamGunItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack, level, entityLiving, timeLeft);
		if (entityLiving instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
			if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Build_Rider_Items.GEAR_ENGINE.get() || player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Build_Rider_Items.GEAR_REMOCON.get()) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.NEBULA_STEAM_GUN_HELL_BROS.get(), 1));
                player.getItemBySlot(EquipmentSlot.OFFHAND).use(level, player, InteractionHand.OFF_HAND);
            } else if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Build_Rider_Items.GEAR_ENGINE_RED.get() || player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Build_Rider_Items.GEAR_REMOCON_BLUE.get()) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.NEBULA_STEAM_GUN_KAISER.get(), 1));
                player.getItemBySlot(EquipmentSlot.OFFHAND).use(level, player, InteractionHand.OFF_HAND);
            }
		}
	}
}